#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
using namespace std;

#define MAX 100001

int N, M;
int a[MAX], b[MAX];

void binarySearch(int num) {
	int left = 0, right = N - 1;
	while (left <= right) {
		int mid = (left + right) / 2;
		if (num == a[mid]) {
			printf("1\n");
			return;
		}
		else if (num < a[mid]) right = mid - 1;
		else left = mid + 1;
	}
	printf("0\n");
}

int main() {
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		scanf("%d", &a[i]);
	}
	scanf("%d", &M);
	for (int i = 0; i < M; i++) {
		scanf("%d", &b[i]);
	}
	sort(a, a + N);
	for (int i = 0; i < M; i++) {
		binarySearch(b[i]);
	}	
	return 0;
}