#include <stdio.h>

void permutation(int print_numbers[], int natural_numbers[], int n, int m, int idx) {
    
    for (int i = 0; i < n; i++) {
        if (natural_numbers[i] >= print_numbers[idx - 1]) {
            print_numbers[idx] = natural_numbers[i];
            if (idx == m) {
                for (int i = 1; i <= m; i++) {
                    printf("%d ", print_numbers[i]);
                }
                printf("\n");
                continue;
            }
            permutation(print_numbers, natural_numbers, n, m, idx + 1);
        }
    }

    return;
}

int main(void) {
    int n, m;
    int idx = 1;
    int print_num[9] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    int natural_num[8] = {1, 2, 3, 4, 5, 6, 7, 8};
    scanf("%d %d", &n, &m);
    permutation(print_num, natural_num, n, m, idx);
    return 0;
}