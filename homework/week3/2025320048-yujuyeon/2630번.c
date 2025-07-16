#include <stdio.h>
typedef struct {
    int w;
    int b;
} color;
color colored_paper(int paper[][128], int min_row, int max_row, int min_column, int max_column) {
    int size = max_row - min_row + 1;
    static color c;
    static int white = 0;
    static int blue = 0;
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
        white++;
    }
    else if (color == size * size) {
        blue++;
    }
    else {
        colored_paper(paper, min_row, min_row + (size / 2) - 1, min_column, min_column + (size / 2) - 1);
        colored_paper(paper, min_row, min_row + (size / 2) - 1, min_column + (size / 2), max_column);
        colored_paper(paper, min_row + (size / 2), max_row, min_column, min_column + (size / 2) - 1);
        colored_paper(paper, min_row + (size / 2), max_row, min_column + (size / 2), max_column);
    }
    c.w = white;
    c.b = blue;
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