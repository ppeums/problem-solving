#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;

#define MAX 9

int N, M;
int arr[MAX];
bool visit[MAX];

void DFS(int cnt) {
	if (cnt == M) {
		for (int i = 0; i < M; i++) {
			printf("%d ", arr[i]);
		}
		printf("\n");
		return;
	}

	for (int i = 1; i <= N; i++) {
		if (!visit[i]) {
			arr[cnt] = i;
			visit[i] = true;
			DFS(cnt + 1);
			visit[i] = false;
		}
	}
	
}

int main()
{
	scanf("%d %d", &N, &M);

	DFS(0);

	return 0;
}