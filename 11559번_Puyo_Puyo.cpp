#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <vector>
#include <cstring>
using namespace std;

#define N 12
#define M 6

const int dx[4] = { 1,0,-1,0 };
const int dy[4] = { 0,1,0,-1 };

int cnt, ans;
char map[N][M];
bool visit[N][M];
vector<pair<int, int>> v, vtmp;

void DFS(int y, int x) {
	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];

		if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
			if (!visit[ny][nx] && map[ny][nx] == map[y][x]) {
				cnt++;
				visit[ny][nx] = true;
				vtmp.push_back({ ny,nx });
				DFS(ny, nx);
			}
		}
	}
}

int main()
{	
	for (int i = 0; i < N; i++) {
		scanf("%s", map[i]);
	}

	while (1) {
		bool isBoom = false;
		memset(visit, false, sizeof(visit));
		v.clear();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visit[i][j] && map[i][j] != '.') {
					cnt = 1;
					vtmp.push_back({ i,j });
					visit[i][j] = true;
					DFS(i, j);

					if (cnt >= 4) {
						isBoom = true;
						for (int k = 0; k < vtmp.size(); k++) {
							v.push_back(vtmp[k]);
						}
					}
					vtmp.clear();
				}
			}
		}

		for (int i = 0; i < v.size(); i++) {
			map[v[i].first][v[i].second] = '.';
		}

		for (int i = 0; i < M; i++) {
			for (int j = 10; j >= 0; j--) {
				for (int k = 11; k > j; k--) {
					if (map[j][i] != '.' && map[k][i] == '.') {
						map[k][i] = map[j][i];
						map[j][i] = '.';
						break;
					}
				}
			}
		}

		if (isBoom) ans++;
		else break;
	}

	printf("%d\n", ans);

	return 0;
}
