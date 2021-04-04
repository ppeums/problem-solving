#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <queue>
#include <vector>
using namespace std;

#define MAX 2001

int N, A, B, num, ans;
priority_queue<int, vector<int>, less<int>> one, two;
vector<int> v;

int main()
{
	scanf("%d %d %d", &N, &A, &B);

	for (int i = 0; i < A; i++) {
		scanf("%d", &num);
		one.push(num);
	}
	for (int i = 0; i < B; i++) {
		scanf("%d", &num);
		two.push(num);
	}

	int tsize = N;

	for (int i = 0; i < B; i++) {
		if (tsize < 2) break;
		v.push_back(two.top());
		two.pop();
		tsize -= 2;
	}

	for (int i = 0; i < tsize; i++) {
		ans += one.top();
		one.pop();
	}

	for (int i = v.size() - 1; i >= 0; i--) {
		if (one.size() < 2) break;

		int n1 = one.top();
		one.pop();
		int n2 = one.top();
		one.pop();

		if (n1 + n2 > v[i]) 
			v[i] = n1 + n2;
		else break;
	}

	for (int i = 0; i < v.size(); i++) {
		ans += v[i];
	}

	printf("%d\n", ans);	

	return 0;
}
