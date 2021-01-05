#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <queue>
using namespace std;

#define MAX 1001

const int dx[4] = { 1,0,-1,0 };
const int dy[4] = { 0,1,0,-1 };

int N, M;
int map[MAX][MAX];
int visit[MAX][MAX][2];
queue<pair<pair<int, int>, int>> q;

int BFS() {
	q.push({ {1,1},1 });
	visit[1][1][1] = 1;

	while (!q.empty()) {
		int y = q.front().first.first;
		int x = q.front().first.second;
		int block = q.front().second;
		q.pop();

		if (y == N && x == M) {
			return visit[y][x][block];
		}

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny >= 1 && ny <= N && nx >= 1 && nx <= M) {
				if (map[ny][nx] == 0 && visit[ny][nx][block] == 0) {
					visit[ny][nx][block] = visit[y][x][block] + 1;
					q.push({ {ny,nx},block });
				}
				else if (map[ny][nx] == 1 && block == 1) {
					visit[ny][nx][block - 1] = visit[y][x][block] + 1;
					q.push({ {ny,nx},block - 1 });
				}
			}
		}
	}
	return -1;
}

int main()
{
	scanf("%d %d", &N, &M);

	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			scanf("%1d", &map[i][j]);
		}
	}

	printf("%d\n", BFS());

	return 0;
}
