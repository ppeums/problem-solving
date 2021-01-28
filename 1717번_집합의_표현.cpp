#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;

#define MAX 1000001

int N, M;
int parent[MAX];

void Init() {
	for (int i = 0; i <= N; i++) {
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
	parent[b] = a;
}

int main()
{	
	scanf("%d %d", &N, &M);

	Init();

	for (int i = 0; i < M; i++) {
		int op, a, b;
		scanf("%d %d %d", &op, &a, &b);
		if (op == 0)
			Union(a, b);
		else {
			if (Find(a) == Find(b)) 
				printf("YES\n");
			else 
				printf("NO\n");
		}
	}

	return 0;
}
