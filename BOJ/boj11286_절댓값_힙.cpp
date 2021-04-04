// 시간복잡도 O(NlogN)

#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <queue>
using namespace std;

struct my {
	int value;
	my(int value) : value(value) {}
};

struct compare {
	bool operator()(my a, my b) {
		if (abs(a.value) == abs(b.value))
			return a.value > b.value;
		else
			return abs(a.value) > abs(b.value);
	}
};

int N, x;
priority_queue<my, vector<my>, compare> pq;

int main()
{
	scanf("%d", &N);

	for (int i = 0; i < N; i++) {
		scanf("%d", &x);
		if (x != 0) {
			pq.push(my(x));
		}
		else {
			if (pq.empty()) {
				printf("0\n");
			}
			else {
				printf("%d\n", pq.top().value);
				pq.pop();
			}
		}
	}

	return 0;
}
