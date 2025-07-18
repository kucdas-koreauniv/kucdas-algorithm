#include <stdio.h>

typedef struct {
    int index;
    int height;
} Tower;

Tower stack[500001];
int top = -1, n, i, h;

int main() {
    scanf("%d", &n);
    for (i = 1; i <= n; i++) {
        scanf("%d", &h);
        while (top >= 0 && stack[top].height < h)
            top--;
        if (top >= 0)
            printf("%d ", stack[top].index);
        else
            printf("0 ");
        stack[++top].index = i;
        stack[top].height = h;
    }
    return 0;
}
