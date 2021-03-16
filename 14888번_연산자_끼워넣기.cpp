#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;

#define MAX 12
#define INF 1000000000
#define MINF -1000000000

int N, maxi = MINF, mini = INF;
int num[MAX], op[4], arr[MAX];

int calc(int a, int b, int op) {
	if (op == 0)
		return a + b;
	else if (op == 1)
		return a - b;
	else if (op == 2)
		return a * b;
	else
		return a / b;
}

void DFS(int cnt) {
	if (cnt == N - 1) {
		int ans = calc(num[0], num[1], arr[0]);
		for (int i = 2; i < N; i++) {
			ans = calc(ans, num[i], arr[i - 1]);
		}
		maxi = (maxi < ans) ? ans : maxi;
		mini = (mini > ans) ? ans : mini;
		return;
	}
	for (int i = 0; i < 4; i++) {
		if (op[i] > 0) {
			op[i]--;
			arr[cnt] = i;
			DFS(cnt + 1);
			op[i]++;
		}
	}
}

int main()
{
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		scanf("%d", &num[i]);
	}
	for (int i = 0; i < 4; i++) {
		scanf("%d", &op[i]);
	}
	DFS(0);
	printf("%d\n%d\n", maxi, mini);
	return 0;
}
