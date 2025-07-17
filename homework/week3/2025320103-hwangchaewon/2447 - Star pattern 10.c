#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char Star(int one_side, int real_y, int real_x)
{
    if (one_side == 1)
        return '*';

    int one_third = one_side / 3;        // 사각형 한 변의 3분의 1
    int two_thirds = (one_side / 3) * 2; // 사각형 한 변의 3분의 2

    if ((real_y > one_third && real_y <= two_thirds) && (real_x > one_third && real_x <= two_thirds))
    {
        return ' ';
    }
    else
    {
        return Star(one_third, real_y % one_third, real_x % one_third);
    }
}

int main()
{

    int num;
    scanf("%d", &num);

    char **pp_star = (char **)malloc(sizeof(char *) * num);

    for (int y_index = 0; y_index < num; y_index++)
    {
        *(pp_star + y_index) = (char *)malloc(sizeof(char) * num + 1);
        for (int x_index = 0; x_index < num; x_index++)
        {

            *(*(pp_star + y_index) + x_index) = Star(num, y_index + 1, x_index + 1); // 0~num-1의 인덱스 말고 1~num의 숫자로 가로 세로 좌표를 받음
        }
        *(*(pp_star + y_index) + num) = '\0';
        printf("%s", *(pp_star + y_index));
        printf("\n");
        free(*(pp_star + y_index));
    }
    free(pp_star);

    return 0;
}