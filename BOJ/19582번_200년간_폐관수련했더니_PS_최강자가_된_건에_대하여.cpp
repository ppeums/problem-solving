#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;

#define MAX 100001

int N, X, P, maxi, pass = 1;
long long sum;

int main()
{
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		scanf("%d %d", &X, &P);
		if (sum <= X) {
			sum += P;
			maxi = (maxi < P) ? P : maxi;
		}
		else if (sum - maxi > X || maxi < P) {
			pass--;
		}
		else {
			pass--;
			sum -= maxi;
			sum += P;
		}
		if (pass < 0) {
			printf("Zzz\n");
			return 0;
		}
	}
	printf("Kkeo-eok\n");
	return 0;
}
