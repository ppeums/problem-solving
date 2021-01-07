#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <queue>
using namespace std;

#define MAX 101

const int dx[6] = { 1,0,0,-1,0,0 };
const int dy[6] = { 0,1,0,0,-1,0 };
const int dz[6] = { 0,0,1,0,0,-1 };

int M, N, H;
int map[MAX][MAX][MAX];
bool visit[MAX][MAX][MAX];
queue<pair<int, pair<int, int>>> q;

bool allRipe() {
	for (int k = 0; k < H; k++) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[k][i][j] == 0) {
					return false;
				}
			}
		}
	}
	return true;
}

int BFS() {
	int cnt = 0;

	while (!q.empty()) {
		int size = q.size();

		for (int t = 0; t < size; t++) {
			int z = q.front().first;
			int y = q.front().second.first;
			int x = q.front().second.second;
			q.pop();

			for (int i = 0; i < 6; i++) {
				int nz = z + dz[i];
				int ny = y + dy[i];
				int nx = x + dx[i];

				if (nz >= 0 && nz < H && ny >= 0 && ny < N && nx >= 0 && nx < M) {
					if (!visit[nz][ny][nx] && map[nz][ny][nx] == 0) {
						q.push({ nz,{ny,nx} });
						visit[nz][ny][nx] = true;
						map[nz][ny][nx] = 1;
					}
				}
			}
		}
		cnt++;
	}

	if (allRipe())
		return cnt - 1;
	else 
		return -1;
}

int main()
{
	scanf("%d %d %d", &M, &N, &H);

	for (int k = 0; k < H; k++) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				scanf("%d", &map[k][i][j]);
			}
		}
	}

	if (allRipe()) {
		printf("0\n");
		return 0;
	}

	for (int k = 0; k < H; k++) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[k][i][j] == 1 && !visit[k][i][j]) {
					q.push({ k,{i,j} });
					visit[k][i][j] = true;
				}
			}
		}
	}

	printf("%d\n", BFS());

	return 0;
}
