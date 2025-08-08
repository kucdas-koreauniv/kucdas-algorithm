#include<stdio.h>

int i = 0;
int start = 1;


void forfor(int N, int M, int printing[]) {
	if (i != M) {
		int k;

		if (i >= 1) {
			start = printing[i - 1];
		}
		else {
			start = 1;
		}

		for (k = start ; k < N + 1; k++) {

			printing[i] = k;
			i++;
			forfor(N, M, printing);


		}
		if (i >= 1) {
			i--;
		}


	}
	else {
		for (int k = 0; k < M; k++) {
			printf("%d ", printing[k]);
		}
		printf("\n");
		i--;
	}
}



int main() {

	int N, M;
	int printing[8] = { 0 };

	scanf("%d %d", &N, &M);





	forfor(N, M, printing);







	return 0;
}