#include <stdio.h>
#include <stdlib.h>

void cut(int **origin_paper, int origin_side, int y_start_index, int x_start_index, int *num_coloredpaper)
{
    int cutflag = 0;
    int y_end_index = y_start_index + origin_side;
    int x_end_index = x_start_index + origin_side;

    for (int y = y_start_index; y < y_end_index; y++)
    {
        for (int x = x_start_index; x < x_end_index; x++)
        {
            if (origin_paper[y][x] != origin_paper[y_start_index][x_start_index])
            {
                cutflag = 1;
                break;
            }
        }
        if (cutflag == 1)
        {
            break;
        }
    }
    if (cutflag == 1)
    {
        // 자르기(4등분)
        int new_side = origin_side / 2;
        int y_new_index = y_start_index + new_side;
        int x_new_index = x_start_index + new_side;
        cut(origin_paper, new_side, y_start_index, x_start_index, num_coloredpaper);
        cut(origin_paper, new_side, y_new_index, x_start_index, num_coloredpaper);
        cut(origin_paper, new_side, y_start_index, x_new_index, num_coloredpaper);
        cut(origin_paper, new_side, y_new_index, x_new_index, num_coloredpaper);
    }
    else
    {
        num_coloredpaper[origin_paper[y_start_index][x_start_index]]++;
    }
    return;
}

int main()
{
    int origin_side;
    scanf("%d", &origin_side);

    int **origin_paper = (int **)malloc(sizeof(int *) * origin_side);
    for (int y = 0; y < origin_side; y++)
    {
        *(origin_paper + y) = (int *)malloc(sizeof(int) * origin_side);
        for (int x = 0; x < origin_side; x++)
        {
            scanf("%d", &origin_paper[y][x]);
        }
    }

    int num_coloredpaper[2] = {
        0,
    };

    cut(origin_paper, origin_side, 0, 0, num_coloredpaper);

    for (int y = 0; y < origin_side; y++)
    {
        free(*(origin_paper + y));
    }
    free(origin_paper);

    printf("%d\n%d", num_coloredpaper[0], num_coloredpaper[1]);

    return 0;
}