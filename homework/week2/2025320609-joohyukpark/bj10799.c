#include <stdio.h>
#include <string.h>

char s[100001];
int stack[100001], top = -1;

int main() {
    scanf("%s", s);
    int i, count = 0;
    for (i = 0; s[i]; i++) {
        if (s[i] == '(') {
            stack[++top] = i;
        }
        else {
            if (s[i - 1] == '(') {
                top--;
                count += top + 1;
            }
            else {
                top--;
                count += 1;
            }
        }
    }
    printf("%d\n", count);
    return 0;
}
