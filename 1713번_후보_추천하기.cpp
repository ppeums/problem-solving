#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;

#define MAX 101
#define INF 987654321

int N, K, num;
int vote[MAX];
queue<int> q;
vector<int> v;

int main()
{
	scanf("%d %d", &N, &K);

	for (int i = 0; i < K; i++) {
		scanf("%d", &num);
		int size = q.size();
		if (size < N) {
			if (vote[num] == 0) {
				q.push(num);
			}
		}
		else if (size == N) {
			if (vote[num] == 0) {
				int mini = INF;
				bool hasMin = false;
				for (int j = 0; j < N; j++) {
					int tmp = q.front();
					mini = (mini > vote[tmp]) ? vote[tmp] : mini;
					q.pop();
					q.push(tmp);
				}
				for (int j = 0; j < N; j++) {
					int tmp = q.front();
					if (!hasMin && mini == vote[tmp]) {
						hasMin = true;
						vote[tmp] = 0;
						q.pop();
						
					}
					else {
						q.pop();
						q.push(tmp);
					}
				}
				q.push(num);
			}
		}
		vote[num]++;
	}

	while(!q.empty()) {
		v.push_back(q.front());
		q.pop();
	}

	sort(v.begin(), v.end());

	for (int i = 0; i < N; i++) {
		printf("%d ", v[i]);
	}
	printf("\n");

	return 0;
}
