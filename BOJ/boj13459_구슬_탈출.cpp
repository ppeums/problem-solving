#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <queue>
using namespace std;

#define MAX 11

struct bead {
	int ry, rx, by, bx, cnt;
};

const int dx[4] = { 1,0,-1,0 };
const int dy[4] = { 0,1,0,-1 };

int N, M, rx, ry, bx, by;
char map[MAX][MAX];
bool visit[MAX][MAX][MAX][MAX];
queue<bead> q;

void BFS() {
	while (!q.empty()) {
		int qry = q.front().ry, qrx = q.front().rx;
		int qby = q.front().by, qbx = q.front().bx;
		int cnt = q.front().cnt;

		q.pop();

		if (cnt >= 10) break;

		for (int i = 0; i < 4; i++) {
			int nry = qry, nrx = qrx, nby = qby, nbx = qbx;
			int rcnt = 0, bcnt = 0;

			while (map[nry][nrx] != 'O' && map[nry + dy[i]][nrx + dx[i]] != '#') {
				nry += dy[i], nrx += dx[i];
				rcnt++;
			}
			while (map[nby][nbx] != 'O' && map[nby + dy[i]][nbx + dx[i]] != '#') {
				nby += dy[i], nbx += dx[i];
				bcnt++;
			}

			if (map[nby][nbx] == 'O') continue;
			if (map[nry][nrx] == 'O') {
				printf("1\n");
				return;
			}

			if (nry == nby && nrx == nbx) {
				if (rcnt > bcnt) nry -= dy[i], nrx -= dx[i];
				else nby -= dy[i], nbx -= dx[i];
			}

			if (visit[nry][nrx][nby][nbx]) continue;
			visit[nry][nrx][nby][nbx] = true;
			q.push({ nry,nrx,nby,nbx,cnt + 1 });
		}
	}
	printf("0\n");
}

int main()
{
	scanf("%d %d", &N, &M);

	for (int i = 0; i < N; i++) {
		scanf("%s", map[i]);
		for (int j = 0; j < M; j++) {
			if (map[i][j] == 'R')
				ry = i, rx = j;
			else if (map[i][j] == 'B')
				by = i, bx = j;
		}
	}

	visit[ry][rx][by][bx] = true;
	q.push({ ry,rx,by,bx,0 });
	BFS();

	return 0;
}
