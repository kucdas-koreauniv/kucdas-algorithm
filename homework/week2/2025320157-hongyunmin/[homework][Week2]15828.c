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
    int n, info;

    scanf("%d", &n);
    init_queue(&c_queue, n);

    scanf("%d", &info);
    while(info != -1){
        if(info == 0){
            dequeue(&c_queue);
        }
        else{
            enqueue(&c_queue, info);
        }

        scanf("%d", &info);
    }

    if(isEmpty(&c_queue)){
        printf("empty");
    }
    while(!isEmpty(&c_queue)){
        int tmp = dequeue(&c_queue);
        printf("%d ", tmp);
    }

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