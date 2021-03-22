#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;

#define MAX 1000001

struct DNA {
	int a, c, g, t;
};

int S, P, len, ans;
char str[MAX];
DNA mini, cnt;

void add(char ch) {
	if (ch == 'A') cnt.a++;
	else if (ch == 'C') cnt.c++;
	else if (ch == 'G') cnt.g++;
	else cnt.t++;
}

void remove(char ch) {
	if (ch == 'A') cnt.a--;
	else if (ch == 'C') cnt.c--;
	else if (ch == 'G') cnt.g--;
	else cnt.t--;
}

bool isMeet() {
	if (cnt.a >= mini.a && cnt.c >= mini.c && cnt.g >= mini.g && cnt.t >= mini.t)
		return true;
	return false;
}

int main()
{
	scanf("%d %d", &S, &P);
	scanf("%s", str);
	scanf("%d %d %d %d", &mini.a, &mini.c, &mini.g, &mini.t);

	for (int i = 0; i < S; i++) {
		add(str[i]);
		len++;
		if (len == P) {
			if (isMeet())
				ans++;
			remove(str[i - (P - 1)]);
			len--;
		}
	}
	printf("%d\n", ans);
	return 0;
}
