#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int recursion(const char *s, int l, int r, int *p_num_call)
{
    (*p_num_call)++;

    if (l >= r)
        return 1;
    else if (s[l] != s[r])
        return 0;
    else
        return recursion(s, l + 1, r - 1, p_num_call);
}

int isPalindrome(const char *s, int *p_num_call)
{
    return recursion(s, 0, strlen(s) - 1, p_num_call);
}

int main()
{
    int num_testcase;
    scanf("%d", &num_testcase);

    // T개의 줄에 알파벳 대문자로 구성된 문자열 S 주어짐 (S <= 1000)

        char **pp_str = (char **)malloc(sizeof(char *) * num_testcase);
    for (int i = 0; i < num_testcase; i++)
    {
        *(pp_str + i) = (char *)malloc(sizeof(char) * 1001);
        scanf("%s", *(pp_str + i));

        int num_call = 0;

        printf("%d ", isPalindrome(*(pp_str + i), &num_call));
        printf("%d\n", num_call);
    }

    // 출력 : "isPalindrome() recursion호출횟수"

    return 0;
}