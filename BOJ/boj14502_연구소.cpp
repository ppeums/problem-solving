// 시간복잡도 nmC3 * NM

#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

#define MAX 9

const int dx[4] = { 1,0,-1,0 };
const int dy[4] = { 0,1,0,-1 };

int N, M, ans = 0;
int map[MAX][MAX], tmap[MAX][MAX], arr[3];
bool dvisit[MAX * MAX], bvisit[MAX][MAX];
vector<pair<int, int>> v;
queue<pair<int, int>> q;

void BFS(int y, int x) {
	q.push({ y,x });
	bvisit[y][x] = true;

	while (!q.empty()) {
		int ay = q.front().first;
		int ax = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int ny = ay + dy[i];
			int nx = ax + dx[i];

			if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
				if (tmap[ny][nx] == 0 && !bvisit[ny][nx]) {
					tmap[ny][nx] = 2;
					q.push({ ny,nx });
					bvisit[ny][nx] = true;
				}
			}
		}
	}
}

void DFS(int cnt, int start) {
	if (cnt == 3) {
		memcpy(tmap, map, sizeof(tmap));
		memset(bvisit, false, sizeof(bvisit));

		for (int i = 0; i < 3; i++) {
			int y = v[arr[i]].first;
			int x = v[arr[i]].second;
			tmap[y][x] = 1;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tmap[i][j] == 2 && !bvisit[i][j]) {
					BFS(i, j);
				}
			}
		}

		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tmap[i][j] == 0) {
					cnt++;
				}
			}
		}

		ans = (ans < cnt) ? cnt : ans;

		return;
	}

	for (int i = start; i < v.size(); i++) {
		if (!dvisit[i]) {
			dvisit[i] = 0;
			arr[cnt] = i;
			DFS(cnt + 1, i + 1);
		}
	}

}

int main()
{
	scanf("%d %d", &N, &M);

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			scanf("%d", &map[i][j]);
			if (map[i][j] == 0) {
				v.push_back({ i,j });
			}
		}
	}

	DFS(0, 0);

	printf("%d\n", ans);

	return 0;
}
