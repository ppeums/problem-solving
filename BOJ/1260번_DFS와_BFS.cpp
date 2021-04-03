#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

#define MAX 1001

int N, M, V, v1, v2;
bool dvisit[MAX], bvisit[MAX];

vector<int> map[MAX];
queue<int> q;

void DFS(int start) {
	printf("%d ", start);
	dvisit[start] = true;

	for (int i = 0; i < map[start].size(); i++) {
		int next = map[start][i];
		if (!dvisit[next])
			DFS(next);
	}
}

void BFS(int start) {
	q.push(start);
	bvisit[start] = true;

	while (!q.empty()) {
		start = q.front();
		printf("%d ", start);
		q.pop();

		for (int i = 0; i < map[start].size(); i++) {
			int next = map[start][i];
			if (!bvisit[next]) {
				q.push(next);
				bvisit[next] = true;
			}
		}
	}
}

int main()
{
	scanf("%d %d %d", &N, &M, &V);

	for (int i = 0; i < M; i++) {
		scanf("%d %d", &v1, &v2);
		map[v1].push_back(v2);
		map[v2].push_back(v1);
	}

	for (int i = 1; i <= N; i++) {
		sort(map[i].begin(), map[i].end());
	}

	DFS(V);
	printf("\n");
	BFS(V);
	printf("\n");

	return 0;
}