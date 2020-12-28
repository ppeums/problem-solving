#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <cstring>
using namespace std;

#define MAX 51

const int dx[4] = { 0,1,0,-1 };
const int dy[4] = { 1,0,-1,0 };

int T, M, N, K, X, Y, ans;
int map[MAX][MAX];
bool visit[MAX][MAX];

void DFS(int y, int x) {
	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];
		
		if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
			if (!visit[ny][nx] && map[ny][nx] == 1) {
				visit[ny][nx] = true;
				DFS(ny, nx);
			}
		}
	}
	return;
}

int main()
{
	scanf("%d", &T);

	for (int t = 0; t < T; t++) {
		scanf("%d %d %d", &M, &N, &K);

		memset(map, 0, sizeof(map));
		memset(visit, false, sizeof(visit));
		ans = 0;

		for (int i = 0; i < K; i++) {
			scanf("%d %d", &X, &Y);
			map[Y][X] = 1;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visit[i][j] && map[i][j] == 1) {
					visit[i][j] = true;
					DFS(i, j);
					ans++;
				}
			}
		}
		printf("%d\n", ans);
	}

	return 0;
}