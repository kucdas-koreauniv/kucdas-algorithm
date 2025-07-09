#include <stdio.h>

int stack[100001];
char result[200002];
int top = -1, res_idx = 0;

int main() {
    int n, i, num, cur = 1;
    scanf("%d", &n);

    for (i = 0; i < n; i++) {
        scanf("%d", &num);
        while (cur <= num) {
            stack[++top] = cur++;
            result[res_idx++] = '+';
        }
        if (stack[top] == num) {
            top--;
            result[res_idx++] = '-';
        }
        else {
            printf("NO\n");
            return 0;
        }
    }

    for (i = 0; i < res_idx; i++) {
        printf("%c\n", result[i]);
    }
    return 0;
}
