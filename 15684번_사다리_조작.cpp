#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;

#define NMAX 11
#define HMAX 31

int N, M, H, ladder;
bool isAnswer;
bool map[HMAX][NMAX];

void DFS(int y, int cnt) {
	if (isAnswer) return;
	if (cnt == ladder) {
		bool isPossible = true;
		for (int i = 1; i <= N; i++) {
			int col = i;
			for (int j = 1; j <= H; j++) {
				if (map[j][col]) 
					col++;
				else if (col > 1 && map[j][col - 1])
					col--;
			}
			if (i != col) {
				isPossible = false;
				break;
			}
		}
		if (isPossible)
			isAnswer = true;
		return;
	}
	for (int i = y; i <= H; i++) {
		for (int j = 1; j < N; j++) {
			if (!map[i][j - 1] && !map[i][j] && !map[i][j + 1]) {
				map[i][j] = true;
				DFS(i, cnt + 1);
				map[i][j] = false;
			}
		}
	}
}

int main()
{	
	scanf("%d %d %d", &N, &M, &H);

	for (int i = 0; i < M; i++) {
		int x, y;
		scanf("%d %d", &y, &x);
		map[y][x] = true;
	}

	for (int i = 0; i <= 3; i++) {
		ladder = i;
		DFS(1, 0);
		if (isAnswer) {
			printf("%d\n", ladder);
			return 0;
		}
	}
	printf("-1\n");

	return 0;
}
