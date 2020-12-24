#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
using namespace std;

#define MAX 9

int N, M;
int input[MAX], ans[MAX];
bool visit[MAX];

void DFS(int cnt) {
	if (cnt == M) {
		for (int i = 0; i < M; i++) {
			printf("%d ", ans[i]);
		}
		printf("\n");
		return;
	}

	int before = 0;

	for (int i = 0; i < N; i++) {
		if (!visit[i] && input[i] != before) {
			ans[cnt] = before = input[i];
			visit[i] = true;
			DFS(cnt + 1);
			visit[i] = false;
		}
	}
}

int main()
{
	scanf("%d %d", &N, &M);

	for (int i = 0; i < N; i++) {
		scanf("%d", &input[i]);
	}

	sort(input, input + N);

	DFS(0);

	return 0;
}