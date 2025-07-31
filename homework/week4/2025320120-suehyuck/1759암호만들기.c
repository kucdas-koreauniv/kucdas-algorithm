#include<stdio.h>
#include<stdlib.h>



void insert_sort(int alphabet[], int len) {
	
	for (int k = 1; k < len; k++) {
		int j;
		int key = alphabet[k];
		for (j = k - 1; j >= 0 && alphabet[j] > key; j--) {
			alphabet[j + 1] = alphabet[j];
		}
		alphabet[j+1] = key;

	}
}




int i = 0;
int start = 1;


void forfor(int N, int M, int printing[], int alphabet[]) {
	if (i != M) {
		int k;

		if (i >= 1) {
			start = printing[i - 1];
		}
		else {
			start = 0;
		}

		for (k = start + 1; k < N + 1; k++) {
			printing[i] = k;
			i++;
			forfor(N, M, printing, alphabet);
		}
		if (i >= 1) {
			i--;
		}


	}
	else {
		int vowels = 0, consonants = 0;
		for (int k = 0; k < M; k++) {
			if(alphabet[printing[k] - 1] == 97 || alphabet[printing[k] - 1] == 101 || alphabet[printing[k] - 1] == 105 || alphabet[printing[k] - 1] == 111 || alphabet[printing[k] - 1] == 117){
				vowels++;
			}
			else {
				consonants++;
			}
		}

		if (vowels >= 1 && consonants >= 2) {
			for (int k = 0; k < M; k++) {
				printf("%c", alphabet[printing[k] - 1]);
			}
			printf("\n");
		}
		i--;
	}
}



int main() {

	int L, C;
	char buffer;
	int printing[15] = { 0 };

	scanf("%d %d", &L, &C);

	int* alphabet = (int*)malloc(C * sizeof(int));

	for (int k = 0; k < C; k++) {
		buffer = getchar();
		scanf("%c", &buffer);
		alphabet[k] = buffer;
	}

	insert_sort(alphabet, C);

	forfor(C, L, printing,alphabet);








	return 0;
}