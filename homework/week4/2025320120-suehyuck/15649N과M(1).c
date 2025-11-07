#include<stdio.h>

int i = 0;

void forfor(int N, int M, int used[], int printing[]) {
	if (i != M) {
		int k;
		for (k = 1; k < N + 1; k++) {
			if (used[k] == 0) {
				printing[i] = k;
				used[k] = 1;
				i++;
				forfor(N, M, used, printing);
				used[k] = 0;
			}
			else {
				continue;
			}
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
	int used[9] = { 0 };
	int printing[8] = { 0 };

	scanf("%d %d", &N, &M);




	
	forfor(N, M, used, printing);







	return 0;
}