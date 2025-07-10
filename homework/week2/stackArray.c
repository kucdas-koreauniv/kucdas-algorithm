#include <stdio.h>
#include <stdlib.h>
#define MAX 100000

int stack[MAX];
int top = -1;

void push(int x)
{
    if (top == MAX - 1)
    {
        printf("스택 오버플로우\n");
        return;
    }
    stack[++top] = x;
}

int pop()
{
    if (top == -1)
    {
        printf("스택 언더플로우\n");
        return 0;
    }
    return stack[top--];
}

int main()
{
    int n;
    scanf("%d", &n);
    int *numArray = (int *)malloc(sizeof(int) * n);
    char *opArray = (char *)malloc(sizeof(char) * 2 * n);
    int opNum = 0;
    int num = 1;
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &numArray[i]);
    }
    for (int i = 0; i < n; i++)
    {
        int target = numArray[i];

        // 목표 숫자 target이 나올 때까지 스택에 현재 숫자(1부터 점점 커짐) num을 PUSH.
        while (num <= target)
        {
            push(num++); // num을 push하고 숫자 증가
            opArray[opNum++] = '+';
        }

        // top의 값이 target과 같으면 POP.
        if (stack[top] == target)
        {
            pop();
            opArray[opNum++] = '-';
        }
        else
        {
            // 불가능한 수열. 즉 top의 값이 target보다 큰 경우임.
            printf("NO\n");
            free(numArray);
            free(opArray);
            return 0;
        }
    }
    for (int i = 0; i < opNum; i++)
    {
        printf("%c\n", opArray[i]);
    }
    free(numArray);
    free(opArray);
    return 0;
}