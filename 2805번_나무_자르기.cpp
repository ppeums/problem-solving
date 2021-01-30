#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;

#define MAX 1000001

long long N, M, maxi, ans;
long long tree[MAX];

int main()
{	
	scanf("%lld %lld", &N, &M);

	for (int i = 0; i < N; i++) {
		scanf("%lld", &tree[i]);
		maxi = (maxi < tree[i]) ? tree[i] : maxi;
	}

	long long start = 1;
	long long end = maxi;

	while (start <= end) {
		long long mid = (start + end) / 2;
		long long sum = 0;
		for (int i = 0; i < N; i++) {
			if (tree[i] > mid) {
				sum += (tree[i] - mid);
			}
		}
		if (sum >= M) {
			ans = (ans < mid) ? mid : ans;
			start = mid + 1;
		}
		else end = mid - 1;
	}
	
	printf("%lld\n", ans);
	
	return 0;
}
