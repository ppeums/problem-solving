#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;

#define MAX 10001

int N, M, K, sum;
int pay[MAX], parent[MAX];
bool check[MAX];

void Init() {
	for (int i = 1; i <= N; i++) {
		parent[i] = i;
	}
}

int Find(int a) {
	if (a == parent[a])
		return a;
	else {
		int p = Find(parent[a]);
		parent[a] = p;
		return p;
	}
}

void Union(int a, int b) {
	a = Find(a);
	b = Find(b);
	if (pay[a] < pay[b]) parent[b] = a;
	else parent[a] = b;
}

int main()
{
	scanf("%d %d %d", &N, &M, &K);
	for (int i = 1; i <= N; i++) {
		scanf("%d", &pay[i]);
	}
	Init();
	for (int i = 0; i < M; i++) {
		int v, w;
		scanf("%d %d", &v, &w);
		Union(v, w);
	}
	for (int i = 1; i <= N; i++) {
		int p = Find(i);
		if (!check[p]) {
			check[p] = true;
			sum += pay[p];
		}
	}
	if (sum <= K) printf("%d\n", sum);
	else printf("Oh no\n");
	return 0;
}
