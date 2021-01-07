// 시간복잡도 13Cm * N^2

#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <vector>
using namespace std;

#define MAX 14
#define INF 987654321

int N, M, input, ans = INF;
int arr[MAX];
bool visit[MAX];
vector<pair<int, int>> chick;
vector<pair<int, int>> home;

void DFS(int cnt, int start) {
	if (cnt == M) {
		int sum = 0;
		for (int i = 0; i < home.size(); i++) {
			int mini = INF;
			for (int j = 0; j < M; j++) {
				int dist = abs(home[i].first - chick[arr[j]].first) + abs(home[i].second - chick[arr[j]].second);
				if (mini > dist)
					mini = dist;
			}
			sum += mini;
		}
		if (ans > sum)
			ans = sum;
		return;
	}

	for (int i = start; i < chick.size(); i++) {
		if (!visit[i]) {
			visit[i] = true;
			arr[cnt] = i;
			DFS(cnt + 1, i + 1);
			visit[i] = false;
		}
	}
}

int main()
{
	scanf("%d %d", &N, &M);

	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			scanf("%d", &input);
			if (input == 2) {
				chick.push_back({ i,j });
			}
			else if (input == 1) {
				home.push_back({ i,j });
			}
		}
	}

	DFS(0, 0);
	printf("%d\n", ans);

	return 0;
}
