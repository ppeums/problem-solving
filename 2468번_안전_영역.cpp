#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <queue>
#include <cstring>
using namespace std;

#define MAX 101

const int dx[4] = { 1,0,-1,0 };
const int dy[4] = { 0,1,0,-1 };

int N, maxi, ans;
int map[MAX][MAX];
bool visit[MAX][MAX];

void BFS(int i, int j, int r) {
	queue<pair<int, int>> q;
	q.push({ i,j });
	visit[i][j] = true;

	while (!q.empty()) {
		int qy = q.front().first;
		int qx = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int ny = qy + dy[i];
			int nx = qx + dx[i];

			if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
				if (!visit[ny][nx] && map[ny][nx] > r) {
					q.push({ ny,nx });
					visit[ny][nx] = true;
				}
			}
		}
	}
}

int main()
{
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			scanf("%d", &map[i][j]);
			maxi = (maxi < map[i][j]) ? map[i][j] : maxi;
		}
	}

	for (int r = 0; r <= maxi; r++) {
		memset(visit, false, sizeof(visit));
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j] && map[i][j] > r) {
					BFS(i, j, r);
					cnt++;
				}
			}
		}
		ans = (ans < cnt) ? cnt : ans;
	}

	printf("%d\n", ans);
	
	return 0;
}
