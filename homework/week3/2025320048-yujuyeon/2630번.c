#include <stdio.h>
typedef struct {
    int w;
    int b;
} color;
color colored_paper(int paper[][128], int min_row, int max_row, int min_column, int max_column) {
    int size = max_row - min_row + 1;
    color c;
    c.w = 0;
    c.b = 0;
    color c1;
    color c2;
    color c3;
    color c4;
    //모든 칸이 0만으로 혹은 1만으로 이루어져있는지 조사
    int color = 0;
    for (int i = min_row; i <= max_row; i++) {
        for (int j = min_column; j <= max_column; j++) {
            if (paper[i][j] == 0) {

            }
            else if (paper[i][j] == 1) {
                color++;
            }
        }
    }
    if (color == 0) {
        c.w++;
    }
    else if (color == size * size) {
        c.b++;
    }
    else {
        c1 = colored_paper(paper, min_row, min_row + (size / 2) - 1, min_column, min_column + (size / 2) - 1);
        c2 = colored_paper(paper, min_row, min_row + (size / 2) - 1, min_column + (size / 2), max_column);
        c3 = colored_paper(paper, min_row + (size / 2), max_row, min_column, min_column + (size / 2) - 1);
        c4 = colored_paper(paper, min_row + (size / 2), max_row, min_column + (size / 2), max_column);
        c.w = c1.w + c2.w + c3.w + c4.w;
        c.b = c1.b + c2.b + c3.b + c4.b;
    }
    
    return c;
}
int main(void) {
    int n;
    scanf("%d", &n);
    int input[128][128];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            scanf("%d", &input[i][j]);
        }
    }
    color output = colored_paper(input, 0, n - 1, 0, n - 1);
    printf("%d\n%d", output.w, output.b);

    return 0;
}