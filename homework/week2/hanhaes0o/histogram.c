#include <stdio.h>
#include <stdlib.h>
#define MAX_LEN 100000
#define MAX(a, b) ((a) > (b) ? (a) : (b)) // 넓이의 최댓값을 비교하기 위한 함수 

int stack[MAX_LEN];
int top = -1;

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

int main()
{
    long long areaMax = 0;
    long long resultCount = 0;
    long long resultArray[100000]; // n == 0 일때까지 결과를 저장해뒀다가 한 번에 출력해야하니까 루프 한 번의 areaMax를 저장해놓기 위한 배열을 선언함
    
    while(1){ //n이 0이 아니면 무한루프
        
        int num_inputs;
        scanf("%d", &num_inputs);
        if (num_inputs == 0){
             for (int i = 0; i < resultCount; i++){
                printf("%lld\n", resultArray[i]);
            }
            break; //n == 0일때 resultArray에 저장해둔 결과 출력하고 무한루프 탈출, 코드 종료
        }
        top = - 1;
        areaMax = 0;
        long long *heightArray = malloc(sizeof(long long) * num_inputs); // 내가 입력한 넓이값을 저장할 배열
        for (int i = 0; i < num_inputs; i++)
        {
            scanf("%lld", &heightArray[i]);
        }
        for (int i = 0; i < num_inputs; i++)
        {
            while (!isEmpty() && heightArray[stack[top]] > heightArray[i]) // 이 조건문의 뜻은? 스택이 비어있지 않고, 현재 인덱스(i)의 높이가 스택의 top의 높이보다 작다
            // 가령 3개의 높이 [4 1 5 3] 의 예시를 보자. 이 높이의 인덱스는 각각 [0 1 2 3]일 것이다. 
            // 먼저 0이 들어올 때는 isEmpty 상태이므로 이 조건을 지나가서 push된다. 스택에는 [0]이 존재한다. 그 다음으로 1이 들어올 때, 1의 인덱스의 높이 1이 스택의 top(즉 0)의 높이 4보다 작고
            // 스택이 비어있지도 않으므로 이 조건에 걸린다.
            // 왜 이런 조건을 썼는가? 현재 스택의 top의 높이보다 작은 높이가 들어오면, 이 이상으로 직사각형의 넓이의 증가 가능성이 '차단'된다는 뜻이다. 
            //[4 1 5 3] 에서, 4의 높이는 바로 오른쪽의 1이라는 높이 때문에 너비가 2로 증가될 수 없다. 즉 '차단'된 것이다.
            {
                int tp = pop(); 
                long long height = heightArray[tp];//이는 tp, height라는 변수에 각각 pop한 인덱스와 그 높이를 저장하기 위함이다.
                long long width;
                if (isEmpty())
                {
                    width = i; //스택이 비었을 때 직사각형의 너비는 i가 된다. 위의 에시 [4 1 5 3]의 초반 부분을 보자. 인덱스 1이 들어왔을 때 조건에 걸려 스택에 존재하던 0이 pop되고, 스택은 비어있다.
                    // 스택이 빈다는 것은 왼쪽에 경계가 될 직사각형이 없다는 뜻이다. 즉 너비는 i 그 자체가 된다.
                }
                else
                {
                    width = i - stack[top] - 1; // 스택이 비어있지 않다면 스택의 top이 왼쪽 경계 역할을 한다.  
                }   
                long long area = height * width;
                areaMax = MAX(areaMax, area);
            }
            push(i);
        }// 이 과정을 다 거치면, 스택은 [0] [1] [1 2] [1 3]이 된다. 그리고 0이 pop될때 넓이 4, 2가 pop될때 넓이 5가 나온다. 남은 인덱스 [1 3]도 마저 계산한다.
        //마저 계산하면 인덱스 3이 pop될때 넓이 6, 인덱스 1이 pop될때 넓이 4가 나온다.
        // 즉 이 케이스에서 최대 넓이는 인덱스 3의 높이 3을 이용해 구할 수 있는 6이다. 
        int i = num_inputs;
        while (!isEmpty())
        {
            int tp = pop();
            long long height = heightArray[tp];
            long long width;
            if (isEmpty())
            {
                width = i;
            }
            else
            {
                width = i - stack[top] - 1;
            }   
            long long area = height * width;
            areaMax = MAX(areaMax, area);
        }
        resultArray[resultCount] = areaMax;
        resultCount++;
        free(heightArray);
    }
    return 0;
}