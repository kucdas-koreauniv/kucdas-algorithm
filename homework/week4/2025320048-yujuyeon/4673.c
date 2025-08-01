#include <stdio.h>
int main(void) {
	int a, b, c, d;
	int arr[20000];
	for (int i = 0; i < 10001; i++) {
		arr[i] = i;
	}
	for (int a = 0; a < 10; a++) {
		for (int b = 0; b < 10; b++) {
			for (int c = 0; c < 10; c++) {
				for (int d = 0; d < 10; d++) {
					arr[1001 * a + 101 * b + 11 * c + 2 * d] = 0;
				}
			}
		}
	}
	for (int i = 0; i < 10001; i++) {
		if (arr[i] != 0) {
			printf("%d\n", arr[i]);
		}
	}

	return 0;
}