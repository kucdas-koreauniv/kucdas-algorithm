#include <stdio.h>
#include <string.h>

#define MAX 51  // 괄호 문자열 최대 길이

int main() {
    int T;
    scanf("%d", &T);

    while (T--) {
        char str[MAX];
        scanf("%s", str);

        int balance = 0;
        int isVPS = 1;

        for (int i = 0; i < strlen(str); i++) {
            if (str[i] == '(') {
                balance++;
            }
            else if (str[i] == ')') {
                balance--;
                if (balance < 0) {
                    isVPS = 0;
                    break;
                }
            }
        }

        if (balance != 0) isVPS = 0;

        if (isVPS) {
            printf("YES\n");
        }
        else {
            printf("NO\n");
        }
    }

    return 0;
}
