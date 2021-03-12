#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;

#define MAX 10001

int N, M, sum, ans, start;
int arr[MAX];

int main()
{
	scanf("%d %d", &N, &M);
	for (int i = 0; i < N; i++) {
		scanf("%d", &arr[i]);
	}
	for (int i = 0; i < N; i++) {
		sum += arr[i];
		if (sum >= M) {
			while (sum >= M) {
				if (sum == M)
					ans++;
				sum -= arr[start];
				start++;
			}
		}
	}
	printf("%d\n", ans);
	return 0;
}
