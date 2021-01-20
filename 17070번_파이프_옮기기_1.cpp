#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;

#define MAX 17

int N, ans;
int map[MAX][MAX];

void DFS(int ey, int ex, int state) {
	if (ey == N && ex == N) {
		ans++;
		return;
	}

	if (state == 1) {
		if (ex + 1 <= N) {
			if (map[ey][ex + 1] == 0) {
				DFS(ey, ex + 1, 1);
			}
		}
		if (ex + 1 <= N && ey + 1 <= N) {
			if (map[ey][ex + 1] == 0 && map[ey + 1][ex] == 0 && map[ey + 1][ex + 1] == 0) {
				DFS(ey + 1, ex + 1, 3);
			}
		}
	}
	else if (state == 2) {
		if (ey + 1 <= N) {
			if (map[ey + 1][ex] == 0) {
				DFS(ey + 1, ex, 2);
			}
		}
		if (ex + 1 <= N && ey + 1 <= N) {
			if (map[ey][ex + 1] == 0 && map[ey + 1][ex] == 0 && map[ey + 1][ex + 1] == 0) {
				DFS(ey + 1, ex + 1, 3);
			}
		}
	}
	else if (state == 3) {
		if (ex + 1 <= N) {
			if (map[ey][ex + 1] == 0) {
				DFS(ey, ex + 1, 1);
			}
		}
		if (ey + 1 <= N) {
			if (map[ey + 1][ex] == 0) {
				DFS(ey + 1, ex, 2);
			}
		}
		if (ex + 1 <= N && ey + 1 <= N) {
			if (map[ey][ex + 1] == 0 && map[ey + 1][ex] == 0 && map[ey + 1][ex + 1] == 0) {
				DFS(ey + 1, ex + 1, 3);
			}
		}
	}
}

int main()
{
	scanf("%d", &N);
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			scanf("%d", &map[i][j]);
		}
	}

	DFS(1, 2, 1);

	printf("%d\n", ans);

	return 0;
}
