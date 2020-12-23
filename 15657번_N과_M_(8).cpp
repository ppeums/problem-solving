#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
using namespace std;

#define MAX 9

int N, M;
int input[MAX], ans[MAX];

void DFS(int cnt, int start) {
	if (cnt == M) {
		for (int i = 0; i < M; i++) {
			printf("%d ", ans[i]);
		}
		printf("\n");
		return;
	}

	for (int i = start; i < N; i++) {
		ans[cnt] = input[i];
		DFS(cnt + 1, i);
	}
}

int main()
{
	scanf("%d %d", &N, &M);

	for (int i = 0; i < N; i++) {
		scanf("%d", &input[i]);
	}

	sort(input, input + N);

	DFS(0, 0);

	return 0;
}