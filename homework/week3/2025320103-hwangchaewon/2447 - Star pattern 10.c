#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char star(int one_side, int y_index, int x_index)
{
    if (one_side == 1)
        return '*';

    int one_third = one_side / 3; // 사각형 한 변의 3분의 1

    if (y_index / one_third == 1 && x_index / one_third == 1)
    {
        return ' ';
    }
    else
    {
        return star(one_third, y_index % one_third, x_index % one_third);
    }
}

int main()
{

    int num;
    scanf("%d", &num);

    char *p_star = (char *)malloc(sizeof(char) * num);

    for (int y_index = 0; y_index < num; y_index++)
    {
        for (int x_index = 0; x_index < num; x_index++)
        {
            p_star[x_index] = star(num, y_index, x_index); // 0~num-1의 인덱스 말고 1~num의 숫자로 가로 세로 좌표를 받음
        }
        p_star[num] = '\0';
        printf(p_star);
        printf("\n");
    }
    free(p_star);

    return 0;
}