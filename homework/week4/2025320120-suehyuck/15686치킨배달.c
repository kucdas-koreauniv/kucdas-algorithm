#include<stdio.h>
#include<stdlib.h>

// 치킨집 고르고, 모든 집에서 부터 거리를 구하고 합
// 그냥 좌표말고 하나의 숫자로 받아도 될듯
//가령 N=7이면 18 ==> (3,5) 이런 식으로 계산



int distance(int N, int house_p, int chicken_p) {

	int house_row = 1 + (house_p / N);
	int house_column = 1 + (house_p % N);


	int chicken_row = 1 + (chicken_p / N);
	int chicken_column = 1 + (chicken_p % N);

	int distance = abs(house_row - chicken_row) + abs(house_column - chicken_column);

	return distance;
}

int min_distance(int N, int M, int house_p, int printing[], int chicken[]) {
	int min = 100;

	for (int k = 0; k < M; k++) {
		if (distance(N, house_p,chicken[printing[k]-1]) < min) {
			min = distance(N, house_p, chicken[printing[k]-1]);
		}
	}

	return min;
}

int sum_min_distance(int N, int M, int house[], int hi, int printing[], int chicken[]) {
	int sum = 0;
	for (int k = 0; k < hi; k++) {
		sum += min_distance(N, M, house[k], printing, chicken);
	}

	return sum;
}



int start = 1;
int i = 0;
int sum_min = 250000;


void forfor(int N,int ci, int M, int printing[], int house[], int hi, int chicken[]) {
	if (i != M) {
		int k;

		if (i >= 1) {
			start = printing[i - 1];
		}
		else {
			start = 0;
		}

		for (k = start + 1; k < ci + 1; k++) {
			printing[i] = k;
			i++;
			forfor(N, ci, M, printing, house, hi, chicken);
		}
		if (i >= 1) {
			i--;
		}

	}
	else {
		//for (int k = 0; k < M; k++) {
		//	printf("%d ", printing[k]);
		//}
		//printf("\n");

		//치킨 집 압 겹치게 M개 뽑았어
		// 여기서 도시 부터 최소의 거리 구하기
		if (sum_min_distance(N, M, house, hi, printing, chicken) < sum_min) {
			sum_min = sum_min_distance(N, M, house, hi, printing, chicken);
		}

		i--;
	}

}

int main() {

	int N, M, check;	
	scanf("%d %d", &N, &M);
	
	int* chicken = (int*)malloc(N * N * sizeof(int));
	int* house = (int*)malloc(N * N * sizeof(int));
	int printing[13] = { 0 };
	int hi = 0, ci = 0;

	for (int k = 0; k < N * N; k++) {
		scanf("%d", &check);
		if (check == 1) {
			house[hi] = k;
			hi++;
		}
		else if (check == 2) {
			chicken[ci] = k;
			ci++;
		}
	}

	forfor(N, ci, M, printing,house, hi, chicken);

	printf("%d", sum_min);






	return 0;
}