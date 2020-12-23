#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;

#define MAX 9

int N, M;
int arr[MAX];

void DFS(int cnt, int start) {
	if (cnt == M) {
		for (int i = 0; i < M; i++) {
			printf("%d ", arr[i]);
		}
		printf("\n");
		return;
	}

	for (int i = start; i <= N; i++) {
		arr[cnt] = i;
		DFS(cnt + 1, i);
	}

}

int main()
{
	scanf("%d %d", &N, &M);

	DFS(0, 1);

	return 0;
}