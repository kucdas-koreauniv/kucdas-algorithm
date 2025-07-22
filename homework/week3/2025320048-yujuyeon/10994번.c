#include <stdio.h>
void star(int n, int call) {
    if (n == 1) {
        for (int i = 0; i < call; i++) {
            printf("* ");
        }
        printf("*");
        for (int i = 0; i < call; i++) {
            printf(" *");
        }
        printf("\n");
    }
    else {
        for (int i = 0; i < call; i++) {
            printf("* ");
        }
        for (int i = 0; i < 4 * n - 3; i++) {
            printf("*");
        }
        for (int i = 0; i < call; i++) {
            printf(" *");
        }
        printf("\n");

        for (int i = 0; i < call; i++) {
            printf("* ");
        }
        printf("*");
        for (int i = 0; i < 4 * n - 5; i++) {
            printf(" ");
        }
        printf("*");
        for (int i = 0; i < call; i++) {
            printf(" *");
        }
        printf("\n");

        star(n - 1, call + 1);

        for (int i = 0; i < call; i++) {
            printf("* ");
        }
        printf("*");
        for (int i = 0; i < 4 * n - 5; i++) {
            printf(" ");
        }
        printf("*");
        for (int i = 0; i < call; i++) {
            printf(" *");
        }
        printf("\n");

        for (int i = 0; i < call; i++) {
            printf("* ");
        }
        for (int i = 0; i < 4 * n - 3; i++) {
            printf("*");
        }
        for (int i = 0; i < call; i++) {
            printf(" *");
        }
        printf("\n");
    }
    



}
int main(void) {
    int n;
    scanf("%d", &n);
    star(n, 0);

    return 0;
}