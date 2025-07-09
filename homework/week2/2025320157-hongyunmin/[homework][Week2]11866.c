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
    int n, k, index = 0;
    int result[1000];
    
    scanf("%d %d", &n, &k);
    init_queue(&c_queue, n);

    for(int i = 0; i < n; i++){
        enqueue(&c_queue, i + 1);
    }

    while(!isEmpty(&c_queue)){
        for(int i = 1; i < k; i++){
            enqueue(&c_queue, dequeue(&c_queue));
        }
        result[index++] = dequeue(&c_queue);
    }

    printf("<");
    for(int i = 0; i < n - 1; i++){
        printf("%d, ", result[i]);
    }
    printf("%d>", result[n - 1]);

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