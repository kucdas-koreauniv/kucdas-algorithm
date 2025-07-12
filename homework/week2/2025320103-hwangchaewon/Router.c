#include <stdio.h>
#include <stdlib.h>

typedef struct q
{
    int data;
    struct q *p_next;
} Queue;

Queue *front = NULL;
Queue *rear = NULL;

void Dequeue(Queue **p_front, int *p_count)
{
    Queue *p = *p_front;
    *p_front = (*p_front)->p_next;
    free(p);
    (*p_count)--;
}

void Enqueue(Queue **pp_buffer, int temp, int *p_count, Queue **p_front, Queue **p_rear)
{

    (*pp_buffer)->data = temp;
    (*p_count)++;
    if (*p_front == NULL)
    { // 비어있을 때
        *p_front = *pp_buffer;
        *p_rear = *pp_buffer;
    }
    else
    {
        (*p_rear)->p_next = *pp_buffer;
        *p_rear = *pp_buffer;
    }
}

void dumpQueue(int count, Queue **p_front)
{
    for (int i = 0; i < count; i++)
    {
        Queue *p = *p_front;
        printf("%d ", p->data);
        *p_front = (*p_front)->p_next; // front를 다음 노드로 이동
        free(p);                       // 현재 노드 메모리 해제
    }
}

int main()
{
    int buffer_size;
    scanf("%d", &buffer_size);

    int count = 0;

    while (1)
    {
        int temp = 0;

        scanf("%d", &temp);

        if (temp == -1)
        {
            break;
        }

        switch (temp)
        {
        case 0:
            Dequeue(&front, &count);
            break;
        default:
            if (count < buffer_size)
            {
                Queue *p_buffer = (Queue *)malloc(sizeof(Queue));
                p_buffer->p_next = NULL;

                Enqueue(&p_buffer, temp, &count, &front, &rear);
            }
        }
    }

    dumpQueue(count, &front);

    return 0;
}
