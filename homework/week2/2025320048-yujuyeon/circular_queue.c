#include <stdio.h>
#include <stdlib.h>
typedef struct {
    int* data; // n만큼 동적할당 받을 예정
    int n;
    int front;
    int rear;
    int count;
} Queue;

void init(Queue* q) {
    q->front = 0;
    q->rear = -1;
    q->count = 0;
}

void enqueue(Queue* q, int value) {
    if (q->count == q->n) {
        printf("큐 오버플로우!\n");
    }
    else {
        q->rear = (q->rear + 1) % q->n;
        q->data[q->rear] = value;
        q->count++;
    }
}

void dequeue(Queue* q) {
    if (q->count == 0) {
        printf("큐 언더플로우!\n");
    }
    else {
        q->front = (q->front + 1) % q->n;
        q->count--;
    }
}
int main(void) {
    Queue q;
    init(&q);
    scanf("%d", &q.n);
    q.data = (int*)malloc(sizeof(int) * q.n);
}
