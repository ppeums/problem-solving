#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
using namespace std;

#define MAX 10001

int N, maxi, cnt[MAX];
bool check[MAX];

int main() {
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		int num;
		scanf("%d", &num);
		cnt[num]++;
		check[num] = true;
		maxi = max(maxi, num);
	}
	for (int i = 1; i <= maxi; i++) {
		if (check[i]) {
			for (int j = 0; j < cnt[i]; j++) {
				printf("%d\n", i);
			}
		}
	}
	return 0;
}