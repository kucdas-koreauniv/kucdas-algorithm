#include <stdio.h>
#include <stdlib.h>

typedef struct stack
{
    int height;
    int tower_index;
    struct stack *p_down;
} Stack;

Stack *top = NULL;

int main()
{
    int N;
    scanf("%d", &N);

    for (int i = 0; i < N; i++)
    {
        int temp = 0;

        int success = 0; // 송신 성공 여부

        scanf("%d", &temp);

        // 입력받은 값(temp)을 수신받을 후보 스택(p_recept)에 push
        Stack *p_recept = (Stack *)malloc(sizeof(Stack));
        if (p_recept == NULL)
        {
            printf("메모리 할당 실패");
            return 1;
        }
        p_recept->height = temp;
        p_recept->tower_index = i + 1;
        p_recept->p_down = NULL;

        if (top == NULL)
        {
            top = p_recept;
            printf("0 ");
            continue;
        }

        Stack *p = top; // top부터 탐색 시작.
        while (p != NULL)
        {
            if (p->height < p_recept->height)
            { // 불필요한 탑 제거
                Stack *p_temp = p;

                top = p->p_down;
                p = p->p_down;

                free(p_temp);
                p_temp = NULL;
            }
            else
            { // 송신 시도

                printf("%d ", p->tower_index);
                success = 1;
                break;
            }
        }
        p_recept->p_down = top;
        top = p_recept;

        if (success == 0)
        {
            printf("0 ");
        }
    }

    while (top != NULL)
    {
        Stack *p = top;
        top = top->p_down;
        free(p);
    }

    return 0;
}
