#include<stdio.h>
#include<stdlib.h>

typedef struct{
    int front;
    int rear;
    int queueSize;
    int count;
    int *data;
}CircularQueue;

int init_queue(CircularQueue *, int);
int dequeue(CircularQueue *);
int enqueue(CircularQueue *, int);
int isEmpty(CircularQueue *);
int isFull(CircularQueue *);

int main(){
    CircularQueue c_queue;
    init_queue(&c_queue, 10);

    printf("%d\n", isEmpty(&c_queue));
    enqueue(&c_queue, 0);
    enqueue(&c_queue, 1);
    enqueue(&c_queue, 2);
    enqueue(&c_queue, 3);
    enqueue(&c_queue, 4);
    enqueue(&c_queue, 5);
    enqueue(&c_queue, 6);
    enqueue(&c_queue, 7);
    enqueue(&c_queue, 8);
    enqueue(&c_queue, 9);
    printf("%d\n", isFull(&c_queue));
    printf("%d\n", dequeue(&c_queue));
    printf("%d\n", dequeue(&c_queue));
    enqueue(&c_queue, 10);
    enqueue(&c_queue, 11);
    printf("%d\n", dequeue(&c_queue));
    printf("%d\n", dequeue(&c_queue));
    printf("%d\n", dequeue(&c_queue));
    printf("%d\n", dequeue(&c_queue));
    printf("%d\n", dequeue(&c_queue));
    printf("%d\n", dequeue(&c_queue));
    printf("%d\n", dequeue(&c_queue));
    printf("%d\n", dequeue(&c_queue));
    printf("%d\n", dequeue(&c_queue));
    printf("%d\n", dequeue(&c_queue));

    free(c_queue.data);
    return 0;
}

int init_queue(CircularQueue *c_queue, int n){
    c_queue->front = 0;
    c_queue->rear = 0;
    c_queue->queueSize = n;
    c_queue->count = 0;
    c_queue->data = (int *)malloc(sizeof(int) * n);
}

int dequeue(CircularQueue *c_queue){
    if(isEmpty(c_queue)){
        return -1;
    }
    int data = c_queue->data[c_queue->front];
    c_queue->count--;
    c_queue->front = (c_queue->front + 1) % c_queue->queueSize;
    return data;
}

int enqueue(CircularQueue *c_queue, int n){
    if(isFull(c_queue)){
        return -1;
    }
    c_queue->data[c_queue->rear] = n;
    c_queue->count++;
    c_queue->rear = (c_queue->rear + 1) % c_queue->queueSize;
    return 0;
}

int isEmpty(CircularQueue *c_queue){
    return c_queue->count == 0;
}

int isFull(CircularQueue *c_queue){
    return c_queue->count == c_queue->queueSize;
}