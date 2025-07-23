#include <stdio.h>
#include <string.h>
void reverse(char* str) {
    int len = strlen(str);
    char temp[50];
    for (int i = 0; i < len; i++) {
        temp[i] = str[len - 1 - i];
    }
    temp[len] = '\0';
    strcpy(str, temp);
}
void T_to_S(char S[], int S_len, char T[], int T_len, int* is_possible) {
    if (S_len == T_len) {
        if (strcmp(S, T) == 0) {
            *is_possible = 1;
        }
        return;
    }
    char T1[51];
    strcpy(T1, T);
    char T2[51];
    strcpy(T2, T);

    if (T[T_len - 1] == 'A') {
        T1[T_len - 1] = '\0';
        T_to_S(S, S_len, T1, T_len - 1, is_possible);
    }
    
    if (T[0] == 'B') {
        char temp[51];
        T2[0] = ' ';
        for (int i = 0; i < T_len; i++) {
            temp[i] = T2[i + 1];
        }
        reverse(temp);
        strcpy(T2, temp);
        T_to_S(S, S_len, T2, T_len - 1, is_possible);
    }
}


int main(void) {
    char s[50];
    char t[51];
    int s_len;
    int t_len;
    scanf("%s", s);
    scanf("%s", t);
    s_len = strlen(s);
    t_len = strlen(t);
    
    int p = 0;
    int* is_possible = &p;
    T_to_S(s, s_len, t, t_len, is_possible);
    printf("%d", p);

    return 0;
}