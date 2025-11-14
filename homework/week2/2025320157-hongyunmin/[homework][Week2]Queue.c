#include<stdio.h>
#include<stdlib.h>

typedef struct{
    int front;
    int rear;
    int queueSize;
    int *data;
}Queue;

int init_queue(Queue *, int);
int dequeue(Queue *);
int enqueue(Queue *, int);
int isEmpty(Queue *);
int isFull(Queue *);

int main(){
    Queue queue;
    init_queue(&queue, 10);

    printf("%d\n", isEmpty(&queue));
    enqueue(&queue, 0);
    enqueue(&queue, 1);
    enqueue(&queue, 2);
    enqueue(&queue, 3);
    enqueue(&queue, 4);
    enqueue(&queue, 5);
    enqueue(&queue, 6);
    enqueue(&queue, 7);
    enqueue(&queue, 8);
    enqueue(&queue, 9);
    printf("%d\n", isFull(&queue));
    printf("%d\n", dequeue(&queue));
    printf("%d\n", dequeue(&queue));

    free(queue.data);
    return 0;
}

int init_queue(Queue *queue, int n){
    queue->front = 0;
    queue->rear = 0;
    queue->queueSize = n;
    queue->data = (int *)malloc(sizeof(int) * n);
}

int dequeue(Queue *queue){
    if(isEmpty(queue)){
        return -1;
    }
    return queue->data[queue->front++];
}

int enqueue(Queue *queue, int n){
    if(isFull(queue)){
        return -1;
    }
    queue->data[queue->rear++] = n;
    return 0;
}

int isEmpty(Queue *queue){
    return queue->rear == queue->front;
}

int isFull(Queue *queue){
    return queue->rear == queue->queueSize - 1;
}