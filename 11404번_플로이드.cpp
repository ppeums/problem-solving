#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
using namespace std;

#define MAX 101
#define INF 987654321

int N, M;
int arr[MAX][MAX];

int main() {
	scanf("%d %d", &N, &M);
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			arr[i][j] = INF;
		}
	}
	for (int i = 0; i < M; i++) {
		int a, b, c;
		scanf("%d %d %d", &a, &b, &c);
		arr[a][b] = min(arr[a][b], c);
	}
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			for (int k = 1; k <= N; k++) {
				arr[j][k] = min(arr[j][k], arr[j][i] + arr[i][k]);
			}
		}
	}
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			if (i == j || arr[i][j] == INF) printf("0 ");
			else printf("%d ", arr[i][j]);
		}
		printf("\n");
	}
	return 0;
}