#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <string>
#include <vector>
#include <stack>
using namespace std;

vector<pair<string, long long>> cmd;
stack<long long> s;

bool func(pair<string, long long> cmd) {
	if (cmd.first.compare("NUM") == 0) {
		s.push(cmd.second);
	}
	else if (cmd.first.compare("POP") == 0) {
		if (s.size() == 0) {
			return false;
		}
		s.pop();
	}
	else if (cmd.first.compare("INV") == 0) {
		if (s.size() == 0) {
			return false;
		}
		s.top() *= -1;
	}
	else if (cmd.first.compare("DUP") == 0) {
		s.push(s.top());
	}
	else {
		if (s.size() < 2) {
			return false;
		}
		long long s1 = s.top(); s.pop();
		long long s2 = s.top(); s.pop();
		if (cmd.first.compare("SWP") == 0) {
			s.push(s1); s.push(s2);
		}
		else if (cmd.first.compare("ADD") == 0) {
			if (abs(s1 + s2) > 1000000000) {
				return false;
			}
			s.push(s1 + s2);
		}
		else if (cmd.first.compare("SUB") == 0) {
			if (abs(s2 - s1) > 1000000000) {
				return false;
			}
			s.push(s2 - s1);
		}
		else if (cmd.first.compare("MUL") == 0) {
			if (abs(s1 * s2) > 1000000000) {
				return false;
			}
			s.push(s1 * s2);
		}
		else if (cmd.first.compare("DIV") == 0) {
			if (s1 == 0 || (abs(s2) / abs(s1)) > 1000000000) {
				return false;
			}
			long long res = abs(s2) / abs(s1);
			if ((s1 > 0 && s2 < 0) || (s1 < 0 && s2 > 0)) {
				res *= -1;
			}
			s.push(res);
		}
		else if (cmd.first.compare("MOD") == 0) {
			if (s1 == 0 || (abs(s2) % abs(s1)) > 1000000000) {
				return false;
			}
			long long res = abs(s2) % abs(s1);
			if (s2 < 0) res *= -1;
			s.push(res);
		}
	}	
	return true;
}

int main()
{
	while (1) {
		cmd.clear();
		while (1) {
			string str;
			long long num = 0;
			cin >> str;

			if (str.compare("QUIT") == 0) return 0;
			if (str.compare("END") == 0) break;
			if (str.compare("NUM") == 0)
				cin >> num;

			cmd.push_back({ str, num });
		}
		long long N;
		cin >> N;
		for (int i = 0; i < N; i++) {
			long long input;
			bool hasError = false;
			cin >> input;

			while (!s.empty()) s.pop();
			s.push(input);

			for (int j = 0; j < cmd.size(); j++) {
				if (!func(cmd[j])) {
					hasError = true;
					break;
				}
			}
			if (!hasError && s.size() == 1) {
				cout << s.top() << endl;
			}
			else {
				cout << "ERROR" << endl;
				continue;
			}
		}
		cout << endl;
	}

	return 0;
}
