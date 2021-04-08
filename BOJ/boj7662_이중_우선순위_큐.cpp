#include <iostream>
#include <queue>
#include <vector>
#include <cstring>
using namespace std;

#define endl '\n'
#define MAX 1000001
#define P pair<int,int>

int T, K, n;
char op;
bool check[MAX], isAnswer;
priority_queue<P> maxi;
priority_queue<P, vector<P>, greater<P>> mini;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cin >> T;
	for (int i = 0; i < T; i++) {
		cin >> K;
		memset(check, false, sizeof(check));
		while (!maxi.empty()) maxi.pop();
		while (!mini.empty()) mini.pop();
		for (int j = 0; j < K; j++) {
			cin >> op >> n;
			if (op == 'I') {
				maxi.push({ n,j });
				mini.push({ n,j });
			}
			else {
				while (!mini.empty() && check[mini.top().second]) mini.pop();
				while (!maxi.empty() && check[maxi.top().second]) maxi.pop();
				if (mini.empty() && maxi.empty()) continue;
				if (n == -1) {
					check[mini.top().second] = true;
					mini.pop();
				}
				else {
					check[maxi.top().second] = true;
					maxi.pop();
				}
			}
		}
		while (!mini.empty() && check[mini.top().second]) mini.pop();
		while (!maxi.empty() && check[maxi.top().second]) maxi.pop();
		if (mini.empty() && maxi.empty())
			cout << "EMPTY" << endl;
		else
			cout << maxi.top().first << ' ' << mini.top().first << endl;
	}
	return 0;
}