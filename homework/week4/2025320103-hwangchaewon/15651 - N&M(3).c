#include <stdio.h>
#include <stdlib.h>

void permutation(int *p, int num, int count, int index)
{

    for (int current_value = 1; current_value <= num; current_value++)
    {

        p[index] = current_value;

        if (index + 1 == count)
        {
            for (int i = 0; i < count; i++)
            {
                printf("%d ", p[i]);
            }
            printf("\n");
            continue;
        }
        else
        {
            permutation(p, num, count, index + 1);
        }
    }
}

int main()
{
    int num;   // 1~num의 자연수 중
    int count; // 중복 없이 count개를 고른 수열
    scanf("%d %d", &num, &count);

    int *p = (int *)malloc(sizeof(int) * count);
    permutation(p, num, count, 0);
    free(p);

    return 0;
}