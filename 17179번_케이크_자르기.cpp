#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;

#define LMAX 4000001
#define MMAX 1002
#define INF 987654321

int N, M, L;
int spot[LMAX], cut[MMAX], piece[MMAX];

int getClose(int n) {
	int mini = INF, ret = 0;
	for (int i = 0; i < M; i++) {
		int diff = abs(spot[i] - n);
		if (diff < mini) {
			mini = diff;
			ret = spot[i];
		}
		else break;
	}
	return ret;
}

int main()
{
	scanf("%d %d %d", &N, &M, &L);
	for (int i = 0; i < M; i++) {
		scanf("%d", &spot[i]);
	}
	for (int i = 0; i < N; i++) {
		int num, div;
		scanf("%d", &num);
		for (int j = 0, k = num + 1; j < num; j++, k--) {
			if (j == 0)
				div = L / k;
			else
				div = (L - cut[j - 1]) / k + cut[j - 1];
			cut[j] = getClose(div);
		}

		cut[num] = L;
		piece[0] = cut[0];
		for (int j = 1; j <= num; j++) {
			piece[j] = cut[j] - cut[j - 1];
		}

		int mini = INF;
		for (int j = 0; j <= num; j++) {
			mini = (mini > piece[j]) ? piece[j] : mini;
		}
		printf("%d\n", mini);
	}

	return 0;
}
