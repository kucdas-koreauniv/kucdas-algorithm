#include <stdio.h>
#include <stdlib.h>
int n;
int count = 0;
typedef struct {
    int* data;
    int front;
    int rear;
} Queue;

void init(Queue* q) {
    q->front = 0;
    q->rear = -1;
}

void enqueue(Queue* q, int value) {
    if (count == n) {
        //printf("큐 오버플로우!\n");
        return;
    }
    q->rear = (q->rear + 1) % n;
    q->data[q->rear] = value;
    count++;
}

void dequeue(Queue* q) {
    if (count == 0) {
        //printf("큐 언더플로우!\n");
        return;
    }
    q->front = (q->front + 1) % n;
    count--;
}


int main(void) {
    int input = 0;;
    Queue input_queue;
    init(&input_queue);
    scanf("%d", &n);
    input_queue.data = (int*)malloc(sizeof(int) * n);
    while (1) {
        scanf("%d", &input);
        switch(input) {
            case 0:
                dequeue(&input_queue);
                break;
            case -1:
                break;
            default:
                enqueue(&input_queue, input);
        }
    }
    if (count == 0) {
        printf("empty");
    }
    else {
        for (int i = 0; i < count; i++) {
            printf("%d ", input_queue.data[(input_queue.front + i) % n]);
        }
    }
    free(input_queue.data);
    return 0;
}