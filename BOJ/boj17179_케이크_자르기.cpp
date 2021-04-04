#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;

#define MMAX 1002

int N, M, L, Q;
int arr[MMAX];

bool canCut(int size) {
	int now = 0, cnt = 0;
	for (int i = 0; i <= M; i++) {
		now += arr[i];
		if (now >= size) {
			cnt++;
			now = 0;
		}
	}
	return (cnt >= Q + 1);
}

int main()
{
	scanf("%d %d %d", &N, &M, &L);
	for (int i = 0; i < M; i++) {
		scanf("%d", &arr[i]);
	}
	arr[M] = L;
	for (int j = M; j > 0; j--) {
		arr[j] -= arr[j - 1];
	}
	for (int i = 0; i < N; i++) {
		scanf("%d", &Q);
		int low = 0, high = L;
		while (high - low > 1) {
			int mid = (low + high) / 2;
			if (canCut(mid)) low = mid;
			else high = mid;
		}
		printf("%d\n", low);
	}
	return 0;
}
