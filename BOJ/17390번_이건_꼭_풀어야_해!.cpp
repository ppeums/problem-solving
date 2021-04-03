#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
using namespace std;

#define MAX 300001

int N, Q;
int arr[MAX], sum[MAX];

int main()
{
	scanf("%d %d", &N, &Q);
	for (int i = 1; i <= N; i++) {
		scanf("%d", &arr[i]);
	}
	sort(arr + 1, arr + N + 1);
	for (int i = 1; i <= N; i++) {
		sum[i] = sum[i - 1] + arr[i];
	}
	for (int i = 0; i < Q; i++) {
		int L, R;
		scanf("%d %d", &L, &R);
		printf("%d\n", sum[R] - sum[L - 1]);
	}	
	return 0;
}
