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
    }
    else {
        q->rear = (q->rear + 1) % n;
        q->data[q->rear] = value;
        count++;
    }
}

void dequeue(Queue* q) {
    if (count == 0) {
        //printf("큐 언더플로우!\n");
    }
    else {
        q->front = (q->front + 1) % n;
        count--;
    }
}


int main(void) {
    int input = 0;;
    Queue q;
    init(&q);
    scanf("%d", &n);
    q.data = (int*)malloc(sizeof(int) * n);
    while (1) {
        scanf("%d", &input);
        if (input == 0) {
            dequeue(&q);
        }
        else if  (input == -1) {
            break;
        }
        else {
            enqueue(&q, input);
        }
    }
    if (count == 0) {
        printf("empty");
    }
    else {
        for (int i = 0; i < count; i++) {
            printf("%d ", q.data[(q.front + i) % n]);
        }
    }
    free(q.data);
    return 0;
}