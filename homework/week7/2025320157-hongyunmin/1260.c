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
int isFull(Queue *queue);
void dfs(int**, int*, int, int);
void bfs(int**, int*, Queue, int, int);

int main(){
    int num_vertex, num_node, start_vertex;
    scanf("%d %d %d", &num_vertex, &num_node, &start_vertex);
    int* visited = (int*)calloc(num_vertex + 1, sizeof(int));
    Queue queue;
    init_queue(&queue, num_vertex + 1);
    int** graph = (int**)malloc((num_vertex + 1) * sizeof(int*));
    for(int i = 0; i < num_vertex + 1; i++){
        graph[i] = (int*)calloc(num_vertex + 1, sizeof(int));
    }

    for(int i = 0; i < num_node; i++){
        int v1, v2;
        scanf("%d %d", &v1, &v2);
        graph[v1][v2] = 1;
        graph[v2][v1] = 1;
    }

    dfs(graph, visited, start_vertex, num_vertex + 1);
    printf("\n");
    
    for(int i = 0; i < num_vertex + 1; i++){
        visited[i] = 0;
    }
    bfs(graph, visited, queue, start_vertex, num_vertex + 1);

    return 0;
}

void dfs(int** graph, int* visited, int vertex, int graph_size){
    if(visited[vertex]){
        return;
    }
    printf("%d ", vertex);
    visited[vertex] = 1;
    for(int i = 1; i < graph_size; i++){
        if(graph[vertex][i]){
            dfs(graph, visited, i, graph_size);
        }
    }
}

void bfs(int** graph, int* visited, Queue queue, int start_vertex, int graph_size){
    enqueue(&queue, start_vertex);
    visited[start_vertex] = 1;
    while(!isEmpty(&queue)){
        int vertex = dequeue(&queue);
        printf("%d ", vertex);
        for(int i = 1; i < graph_size; i++){
            if(graph[vertex][i] && !visited[i]){
                visited[i] = 1;
                enqueue(&queue, i);
            }
        }
    }
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