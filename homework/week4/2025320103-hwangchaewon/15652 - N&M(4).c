#include <stdio.h>
#include <stdlib.h>

void permutation(int *p, int num, int count, int index)
{

    for (int current_value = 1; current_value <= num; current_value++)
    {
        // 이전 값보다 작은 값이면 넘어가기
        int continue_flag = 0;
        for (int i = 0; i < index; i++)
        {
            if (current_value < p[i])
            {
                continue_flag = 1;
                break;
            }
        }

        if (continue_flag)
        {
            continue;
        }
        else
        { // 중복이 안 되는 경우
            // p에 저장
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