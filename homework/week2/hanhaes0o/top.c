#include <stdio.h>
#include <stdlib.h>
#define MAX 500000

int stack[MAX];
int top = -1;

void push(int x)
{
    stack[++top] = x;
}

int pop()
{
    return stack[top--];
}

int main()
{
    int n;
    scanf("%d", &n);
    int *heightArray = (int *)malloc(sizeof(int) * n);
    int *resultArray = (int *)malloc(sizeof(int) * n);
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &heightArray[i]);
    }
    for (int i = 0; i < n; i++)
    {
        while (top >= 0 && heightArray[stack[top]] < heightArray[i]) // top이 0 이상, 즉 스택이 비지 않은 상태 +  스택에 남아 있는 탑이 현재 탑보다 낮으면(즉 필요 없음) pop
        {
            pop();
        }
        if (top < 0) // top이 -1인 경우를 가리킴. 즉 스택이 빈 상태, 가장 왼쪽의 탑. 왼쪽으로 레이저를 쏘니까 무조건 result가 0임
        {
            resultArray[i] = 0;
        }
        else //스택이 비지 않았고, 스택에 남아 있는 탑이 현재 탑보다 높은 상태이므로 result에 top의 인덱스 + 1을 저장
        {
            resultArray[i] = stack[top] + 1; 
        }
        push(i); //현재 탑의 인덱스값을 스택에 push
    }
    for (int i = 0; i < n; i++)
    {
        printf("%d ", resultArray[i]);
    }

    free(heightArray);
    free(resultArray);
    return 0;
}
//원래 높이를 직접 스택에 모두 push하고, top과 target을 두고 하나하나 비교하는 방식으로 코딩했는데 시간초과가 뜸. 그래서 탑의 인덱스를 한 번씩만 push/pop 할 수 있게 새로 코딩함.