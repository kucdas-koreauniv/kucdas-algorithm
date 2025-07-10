#include<stdio.h>
#include<stdlib.h>
#include<string.h>

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
    int num_card, index = 0;
    int result[1000];
    
    scanf("%d", &num_card);
    init_queue(&c_queue, num_card);

    for(int i = 0; i < num_card; i++){
        enqueue(&c_queue, i + 1);
    }

    while(c_queue.count > 1){
        dequeue(&c_queue);
        enqueue(&c_queue, dequeue(&c_queue));
    }

    printf("%d", dequeue(&c_queue));

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