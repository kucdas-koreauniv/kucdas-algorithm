#include <stdio.h>
int main(void) {

    int t;
    scanf("%d", &t);

    for (int i = 0; i < t; i++) {
        char ps[51];
        int balance = 0;
        scanf("%s", ps);

        for (int j = 0; ps[j] != '\0'; j++) {
            if (ps[j] == '(') balance++;
            else if (ps[j] == ')') balance--;

            if (balance < 0) break;
        }

        if (balance == 0) printf("YES\n");
        else printf("NO\n");
    }

    return 0;
}