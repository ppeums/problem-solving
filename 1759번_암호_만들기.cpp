#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
using namespace std;

#define MAX 16

int L, C;
char input[MAX], arr[MAX];
bool visit[MAX];

bool hasRule() {
	int mo = 0, ja = 0;
	for (int i = 0; i < L; i++) {
		(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') ? mo++ : ja++;
	}
	return (mo >= 1 && ja >= 2) ? true : false;
}

void DFS(int cnt, int start) {
	if (cnt == L) {
		if (hasRule()) {
			for (int i = 0; i < L; i++) {
				printf("%c", arr[i]);
			}
			printf("\n");
		}
		return;
	}

	for (int i = start; i < C; i++) {
		if (!visit[i]) {
			visit[i] = true;
			arr[cnt] = input[i];
			DFS(cnt + 1, i + 1);
			visit[i] = false;
		}
	}
}

int main()
{
	scanf("%d %d", &L, &C);

	for (int i = 0; i < C; i++) {
		scanf(" %c", &input[i]);
	}

	sort(input, input + C);

	DFS(0, 0);
	
	return 0;
}
