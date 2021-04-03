// 시간복잡도 O(RC)

#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <queue>
using namespace std;

#define MAX 251

const int dx[4] = { 1,0,-1,0 };
const int dy[4] = { 0,1,0,-1 };

int R, C, ocnt, vcnt;
char map[MAX][MAX];
bool visit[MAX][MAX];
queue<pair<int, int>> q;

void BFS() {
	int sheep = 0, wolf = 0;

	while (!q.empty()) {
		int y = q.front().first;
		int x = q.front().second;
		q.pop();

		if (map[y][x] == 'o')
			sheep++;
		else if (map[y][x] == 'v')
			wolf++;

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny >= 0 && ny < R && nx >= 0 && nx < C) {
				if (!visit[ny][nx] && map[ny][nx] != '#') {
					q.push({ ny,nx });
					visit[ny][nx] = true;
				}
			}
		}
	}

	if (sheep > wolf)
		ocnt += sheep;
	else
		vcnt += wolf;
}

int main()
{
	scanf("%d %d", &R, &C);

	for (int i = 0; i < R; i++) {
		scanf("%s", map[i]);
	}

	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			if (!visit[i][j] && map[i][j] != '#') {
				q.push({ i,j });
				visit[i][j] = true;
				BFS();
			}
		}
	}
	
	printf("%d %d\n", ocnt, vcnt);

	return 0;
}
