#include <stdio.h>
#include <string.h>
#define MAX 50 // 문제에서 문자열의 길이가 2이상 50이하
// 스택 구현하기 - 문제에 필요한 부분만 구현하였음
int stack[MAX];
int top; 
void push(int x)
{
    stack[++top] = x;
}

int pop()
{
    return stack[top--];
}

int isEmpty()
{
    return top == -1;
}
//isFull은 필요 없다고 판단함

int main()
{
    top = -1;
    // 데이터의 수를 받는다
    int num;
    scanf("%d", &num);
    // 받은 데이터의 수만큼 반복
    char parentheses[num][100];
    char answer[num][4];
    for (int i = 0; i < num; i++)
    {
         // 괄호 문자열을 받는다
        scanf("%s", parentheses[i]);

        //스택 초기화
        top = -1;
        int valid = 1;
        int length = strlen(parentheses[i]);
        
        // 괄호의 수가 홀수이면 반드시 오류다.
        if (length % 2 == 1)
        {
            strcpy(answer[i],"NO");
            continue;

        }
        
        // 처음이 아니더라도 (나 )가 아니면 오류다.
        for (int j = 0; j < length; j++)
        {
            if (parentheses[i][j] != '(' && parentheses[i][j] != ')')
            {
                valid = 0;
                break;
            }
            if (parentheses[i][j] == '(') {
                push(0);
                if (top >= MAX) {  // 오버플로우 방지
                    valid = 0;
                    break;
                }
            } else {
                // 여는 괄호 없이 닫는 괄호가 오면 오류
                if (isEmpty()) {
                    valid = 0;
                    break;
                }
                pop();
            }
        }

        // 즉 문자열이 끝났을 때 스택이 비어있다면(isEmpty) 옳은 경우이다.
        if (valid && isEmpty())
        {
            strcpy(answer[i],"YES");
        }
        else
        {
            strcpy(answer[i],"NO");
           
        }
    }
    for (int i = 0; i < num; i++){
        printf("%s\n", answer[i]);
    }
    return 0;
}
