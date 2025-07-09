#include <stdio.h>
int main(void) {
    char PS[51];
    int open = 0;
    int close = 0;
    int t;
    scanf ("%d", &t);
    
    for (int i = 0; i < t; i++) {
        open = 0;
        close = 0;
        scanf("%s", PS);
        for (int j = 0; PS[j] != '\0'; j++) {
            if (PS[j] == '(') open++;
            else if (PS[j] == ')') close++;

            if (open < close) {
                printf("NO\n");
                break;
            }
        }
        if (open == close) printf("YES\n");
        else if (open > close) printf("NO\n");
    }

    return 0;
}