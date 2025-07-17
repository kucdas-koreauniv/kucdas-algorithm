#include <stdio.h>
#include <stdlib.h>

void Star(char **pp, int num, int start_index, int end_index)
{

    if (num == 1)
    {
        pp[start_index][start_index] = '*';
        return;
    }
    // 테두리 만들어주기
    for (int x = start_index; x < end_index; x++)
    {
        pp[start_index][x] = '*';
        pp[start_index + 1][x] = ' ';
        pp[end_index - 2][x] = ' ';
        pp[end_index - 1][x] = '*';
    }
    for (int y = start_index + 1; y < end_index - 1; y++)
    {
        pp[y][start_index] = '*';
        pp[y][start_index + 1] = ' ';
        pp[y][end_index - 2] = ' ';
        pp[y][end_index - 1] = '*';
    }

    Star(pp, --num, start_index + 2, end_index - 2);
}

int main()
{
    int num;
    scanf("%d", &num);

    int one_side = (num - 1) * 4 + 1;
    char **pp = (char **)malloc(sizeof(char *) * one_side);

    for (int i = 0; i < one_side; i++)
    {
        *(pp + i) = (char *)malloc(sizeof(char) * (one_side + 1));
        pp[i][one_side] = '\0';
    }

    Star(pp, num, 0, one_side);

    for (int i = 0; i < one_side; i++)
    {
        printf("%s\n", *(pp + i));
        free(*(pp + i));
    }
    free(pp);

    return 0;
}