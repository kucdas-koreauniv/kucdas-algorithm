#include <stdio.h>

void permutation(int print_numbers[], int natural_numbers[], int n, int m, int idx) {
    
    for (int i = 0; i < n; i++) {
        if (natural_numbers[i] != 0) {
            print_numbers[idx] = natural_numbers[i];
            if (idx == m - 1) {
                for (int i = 0; i < m; i++) {
                    printf("%d ", print_numbers[i]);
                }
                printf("\n");
                continue;
            }
            int temps[8];
            for (int i = 0; i < 8; i++) {
                temps[i] = natural_numbers[i];
            }
            temps[i] = 0;
            permutation(print_numbers, temps, n, m, idx + 1);
        }
    }

    return;
}

int main(void) {
    int n, m;
    int idx = 0;
    int print_num[8];
    int natural_num[8] = {1, 2, 3, 4, 5, 6, 7, 8};
    scanf("%d %d", &n, &m);
    permutation(print_num, natural_num, n, m, idx);
    return 0;
}