#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <cstring>
using namespace std;

#define MAX 21

int N, P, E;
int man[MAX], doll[MAX];
bool isAnswer = false;
pair<int, int> input[MAX];

void DFS(int start, int cnt) {
	if (isAnswer) return;
	if (cnt == P) {
		memset(doll, 0, sizeof(doll));
		int smin = 0, smax = 0;
		for (int i = 0; i < P; i++) {
			int idx = man[i];
			doll[idx] = input[idx].first;
			smin += input[idx].first;
			smax += input[idx].second;
		}
		if (E >= smin && E <= smax) {
			while (!isAnswer) {
				for (int i = 1; i <= N; i++) {
					if (smin == E) {
						isAnswer = true;
						break;
					}
					if (doll[i] > 0 && doll[i] < input[i].second)
						doll[i]++, smin++;
				}
			}
		}
		if (isAnswer) {
			for (int i = 1; i <= N; i++) {
				printf("%d ", doll[i]);
			}
			printf("\n");
		}
		return;
	}
	for (int i = start; i <= N; i++) {
		man[cnt] = i;
		DFS(i + 1, cnt + 1);
	}
}

int main()
{
	scanf("%d %d %d", &N, &P, &E);

	for (int i = 1; i <= N; i++) {
		scanf("%d %d", &input[i].first, &input[i].second);
	}

	DFS(1, 0);

	if (!isAnswer) printf("-1\n");

	return 0;
}
