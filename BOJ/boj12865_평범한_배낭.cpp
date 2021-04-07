#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
using namespace std;

#define NMAX 101
#define KMAX 100001

int N, K;
int w[NMAX], v[NMAX], d[NMAX][KMAX];

int main() {
	scanf("%d %d", &N, &K);
	for (int i = 1; i <= N; i++) {
		scanf("%d %d", &w[i], &v[i]);

	}
	for (int i = 1; i <= N; i++) {
		for (int j = 0; j <= K; j++) {
			if (j < w[i]) d[i][j] = d[i - 1][j];
			else d[i][j] = max(d[i - 1][j - w[i]] + v[i], d[i - 1][j]);
		}
	}
	printf("%d\n", d[N][K]);
	return 0;
}