#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <string>
#include <set>
using namespace std;

string str;
set<string> s;

int main()
{
	cin >> str;
	int len = str.length();	
	for (int i = 0; i < len; i++) {
		string tmp = "";
		for (int j = i; j < len; j++) {
			tmp += str[j];
			s.insert(tmp);
		}
	}
	cout << s.size() << endl;	
	return 0;
}
