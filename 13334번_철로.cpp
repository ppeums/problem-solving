#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

int N, D, maxi;
vector<pair<int, int>> v;
priority_queue<int, vector<int>, greater<int>> pq;

int main()
{
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		int h, o;
		scanf("%d %d", &h, &o);
		if (h > o) swap(h, o);
		v.push_back({ o,h });
	}
	scanf("%d", &D);
	sort(v.begin(), v.end());
	for (int i = 0; i < N; i++) {
		int right = v[i].first;
		int left = v[i].second;
		if (right - left <= D)
			pq.push(left);
		else continue;
		while (!pq.empty()) {
			int tmp = pq.top();
			if (right - tmp <= D) break;
			else pq.pop();
		}
		maxi = max(maxi, (int)pq.size());
	}
	printf("%d\n", maxi);
	return 0;
}
