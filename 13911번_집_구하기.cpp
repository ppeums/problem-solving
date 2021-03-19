#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

#define MAX 10003
#define MP 10001
#define SP 10002
#define INF 987654321

int V, E, M, S, ML, SL;
int dist[MAX][2];
bool store[MAX];
vector<pair<int, int>> node[MAX];

void BFS(int v, int idx) {
	queue<pair<int, int>> q;
	q.push({ v,0 });
	dist[v][idx] = 0;
	while (!q.empty()) {
		int cur = q.front().first;
		int sum = q.front().second;
		q.pop();
		for (int i = 0; i < node[cur].size(); i++) {
			int next = node[cur][i].first;
			int cost = node[cur][i].second;
			if (dist[next][idx] > sum + cost) {
				dist[next][idx] = sum + cost;
				q.push({ next,sum + cost });
			}
		}
	}
}

int main()
{
	int a, b, c, n;
	scanf("%d %d", &V, &E);
	for (int i = 1; i <= V; i++) {
		dist[i][0] = INF;
		dist[i][1] = INF;
	}
	for (int i = 0; i < E; i++) {
		scanf("%d %d %d", &a, &b, &c);
		node[a].push_back({ b,c });
		node[b].push_back({ a,c });
	}
	scanf("%d %d", &M, &ML);
	for (int i = 0; i < M; i++) {
		scanf("%d", &n);
		node[MP].push_back({ n,0 });
		store[n] = true;
	}
	scanf("%d %d", &S, &SL);
	for (int i = 0; i < S; i++) {
		scanf("%d", &n);
		node[SP].push_back({ n,0 });
		store[n] = true;
	}
	BFS(MP, 0);
	BFS(SP, 1);
	int ans = INF;
	for (int i = 1; i <= V; i++) {
		if (store[i]) continue;
		if (dist[i][0] > ML || dist[i][1] > SL) continue;
		ans = min(ans, dist[i][0] + dist[i][1]);
	}
	if (ans == INF) printf("-1\n");
	else printf("%d\n", ans);
	return 0;
}
