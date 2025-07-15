#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define MAX_SIZE 100000

typedef struct
{
    int *data; // 동적으로 할당될 배열을 가리키는 포인터
    int top;
} Stack;

// 스택 초기화 (힙에 메모리 할당)
void init(Stack *s)
{
    s->data = (int *)malloc(sizeof(int) * MAX_SIZE);
    if (s->data == NULL)
    { // 메모리 할당 실패 시 오류 처리
        fprintf(stderr, "메모리 할당 실패!\n");
        exit(1); // 프로그램 종료
    }
    s->top = -1;
}

// 스택 메모리 해제
void destroy(Stack *s)
{
    free(s->data);
    s->data = NULL;
}

// 스택이 비었는지 확인
bool isEmpty(Stack *s)
{
    return s->top == -1;
}

// 스택이 가득 찼는지 확인
bool isFull(Stack *s)
{
    return s->top == MAX_SIZE - 1;
}

// 스택에 값 추가 (push)
bool push(Stack *s, int value)
{
    if (isFull(s))
    {
        printf("스택 오버플로우!\n");
        return false;
    }
    s->data[++(s->top)] = value;
    return true;
}

// 스택에서 값 제거 (pop)
bool pop(Stack *s, int *result)
{
    if (isEmpty(s))
    {
        printf("스택 언더플로우!\n");
        return false;
    }
    *result = s->data[(s->top)--];
    return true;
}

// 스택의 top 값을 확인 (pop은 안 함)
bool peek(Stack *s, int *result)
{
    if (isEmpty(s))
    {
        printf("스택이 비어있습니다!\n");
        return false;
    }
    *result = s->data[s->top];
    return true;
}

int main()
{
    int n;
    scanf("%d", &n);

    // 만들어야 될 수열을 저장할 배열
    int *seq = (int *)malloc(sizeof(int) * n);
    if (seq == NULL)
    {
        printf("seq 메모리 할당 실패!\n");
        return 1;
    }

    // 수열을 만드는 게 가능할 경우 출력할 결과
    char *result = (char *)malloc(sizeof(char) * (2 * n + 1));
    if (result == NULL)
    {
        printf("result 메모리 할당 실패!\n");

        free(seq);
        return 1;
    }
    int result_index = 0;

    // 1~n까지 채워놓은 스택
    Stack ascending;
    init(&ascending);

    // 만들어야 될 수열 입력 받기 + 오름차순 스택 채워놓기
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &seq[i]);
        push(&ascending, n - i); // 1부터 n까지 오름차순으로 뺄 수 있게 넣기
    }

    // 실제 연산을 수행할 스택
    Stack stack;
    init(&stack);

    int max_ascending = 0; // 현재까지 스택에 들어간 최대값 (value)

    // i : 만들어야 될 수열의 인덱스
    // seq[i] : 만들어야 될 수열의 값

    // seq[0] 만들기
    for (int r = 0; r < seq[0]; r++)
    {
        int value;
        pop(&ascending, &value);
        push(&stack, value);
        result[result_index++] = '+'; // 스택에 넣었으니 + 출력
    }
    pop(&stack, &max_ascending);
    result[result_index++] = '-';

    for (int i = 1; i < n; i++)
    {
        if (seq[i - 1] < seq[i])
        {
            if (seq[i] < max_ascending)
            {
                printf("NO");
                return 0;
            }
            else
            {
                for (int r = 0; r < seq[i] - max_ascending; r++)
                {
                    int value;
                    pop(&ascending, &value);
                    push(&stack, value);
                    result[result_index++] = '+';
                }
                pop(&stack, &max_ascending);
                result[result_index++] = '-';
            }
        }
        else
        {
            // seq[i - 1] > seq[i]일 때

            int check;
            peek(&stack, &check);
            if (check != seq[i])
            {
                printf("NO");
                return 0;
            }
            else
            {
                int value;
                pop(&stack, &value);
                result[result_index++] = '-';
            }
        }
    }

    for (int k = 0; k < result_index; k++)
    {
        printf("%c\n", result[k]);
    }
    free(seq);
    free(result);
    destroy(&ascending);
    destroy(&stack);

    return 0;
}
