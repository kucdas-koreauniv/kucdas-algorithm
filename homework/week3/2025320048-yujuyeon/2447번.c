#include <stdio.h>
#include <stdlib.h>
void free_2d_square(char** square, int n) {
    for (int i = 0; i < n; i++) {
        free(square[i]);
    }
    free(square);
}
void print_2d_square(char** square, int n) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            printf("%c", square[i][j]);
        }
        printf("\n");
    }
}
char** star(int n) {
    char** square;
    square = (char**)malloc(n * sizeof(char*));
    for (int i = 0; i < n; i++) {
        square[i] = (char*)malloc(n * sizeof(char));
    }

    if (n == 3) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                square[i][j] = '*';
            }
        }
        square[1][1] = ' ';
        
        return square;
    }

    else { // star(n / 3) div 9개로 이루어진 정사각형
        char** div = star(n / 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int div_row = 0; div_row < n / 3; div_row++) {
                    for (int div_column = 0; div_column < n / 3; div_column++) {
                        square[n / 3 * i + div_row][n / 3 * j + div_column] = div[div_row][div_column];
                    }
                }
            }
        }
        free_2d_square(div, n / 3);
        //정사각형 가운데에 div크기만큼 공백 넣기
        for (int i = 0; i < n / 3; i++) {
            for (int j = 0; j < n / 3; j++) {
                square[n / 3 + i][n / 3 + j] = ' ';
            }
        }
        
        return square;
    }
}

int main(void) {
    int n;
    scanf("%d", &n);
    char** output = star(n);
    print_2d_square(output, n);

    return 0;
}