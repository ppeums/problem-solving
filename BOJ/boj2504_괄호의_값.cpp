// 시간복잡도 O(N)

#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <string>
#include <stack>
using namespace std;

int main()
{	
	string input;
	stack<char> s;
	int tmp = 1, ans = 0;
	bool isWrong = false;

	cin >> input;

	int len = input.length();

	for (int i = 0; i < len; i++) {
		if (input[i] == '(') {
			s.push(input[i]);
			tmp *= 2;
		}
		else if (input[i] == '[') {
			s.push(input[i]);
			tmp *= 3;
		}
		else if (input[i] == ')') {
			if (s.empty() || s.top() != '(') {
				isWrong = true;
				break;
			}
			if (s.top() == '(') {
				if (input[i - 1] == '(')
					ans += tmp;
				s.pop();
				tmp /= 2;
			}
		}
		else if (input[i] == ']') {
			if (s.empty() || s.top() != '[') {
				isWrong = true;
				break;
			}
			if (s.top() == '[') {
				if (input[i - 1] == '[')
					ans += tmp;
				s.pop();
				tmp /= 3;
			}
		}
	}

	if (isWrong || !s.empty())
		printf("0\n");
	else
		printf("%d\n", ans);
	
	return 0;
}
