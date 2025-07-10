#include<stdio.h>

int gcd(int a, int b) {
	return b ? gcd(b, a % b) : a;
}


void finding_not_zero(int materials[], int N, int buffer[][4], int buffer2[][4], int* buffer_index, int* buffer2_index) {

	int a, b, p, q;
	while (*buffer_index >= 0) {
		a = buffer[*buffer_index][0];
		b = buffer[*buffer_index][1];
		p = buffer[*buffer_index][2];
		q = buffer[*buffer_index][3];
		(*buffer_index)--;

		if (materials[a] == 0 && materials[b] == 0) {
			(*buffer2_index)++;
			buffer2[*buffer2_index][0] = a;
			buffer2[*buffer2_index][1] = b;
			buffer2[*buffer2_index][2] = p;
			buffer2[*buffer2_index][3] = q;

		}

		else if (materials[a] != 0) {
			for (int i = 0; i < N; i++) {
				materials[i] *= p;
			}
			materials[b] = q * (materials[a] / p);

		}
		else if (materials[b] != 0) {
			for (int i = 0; i < N; i++) {
				materials[i] *= q;
			}
			materials[a] = p * (materials[b] / q);
		}


	}
}



int main() {

	int N;
	int a, b, p, q;
	int materials[10] = { 0 };
	int buffer[10][4];
	int buffer2[10][4];
	int buffer_index = -1;
	int buffer2_index = -1;

	scanf("%d", &N);

	for (int i = 0; i < N - 1; i++) {
		scanf("%d %d %d %d", &a, &b, &p, &q);

		//p와 q를 약분하기
		for (int i = 9; i > 1; i--) {
			if (p % i == 0 && q % i == 0) {
				p = p / i;
				q = q / i;
				break;
			}
		}


		if (i == 0) {
			materials[a] = p;
			materials[b] = q;
		}

		else if (materials[a] == 0 && materials[b] == 0) {
			buffer_index++;
			buffer[buffer_index][0] = a;
			buffer[buffer_index][1] = b;
			buffer[buffer_index][2] = p;
			buffer[buffer_index][3] = q;

		}

		else if (materials[a] != 0) {
			for (int i = 0; i < N; i++) {
				materials[i] *= p;
			}
			materials[b] = q * (materials[a] / p);

		}
		else if (materials[b] != 0) {
			for (int i = 0; i < N; i++) {
				materials[i] *= q;
			}
			materials[a] = p * (materials[b] / q);
		}


	}


	while (buffer_index >= 0 || buffer2_index >= 0) {
		if (buffer_index >= 0) {
			finding_not_zero(materials, N, buffer, buffer2, &buffer_index, &buffer2_index);
		}
		else {
			finding_not_zero(materials, N, buffer2, buffer, &buffer2_index, &buffer_index);
		}
	}


	int total_gcd = materials[0];
	for (int i = 1; i < N; i++) {
		total_gcd = gcd(total_gcd, materials[i]);
	}

	for (int i = 0; i < N; i++) {
		printf("%d ", materials[i] / total_gcd);
	}



	return 0;
}