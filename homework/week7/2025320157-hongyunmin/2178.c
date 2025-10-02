#include<stdio.h>
#include<stdlib.h>

typedef struct{
    int x, y, distance;
}Node;

typedef struct{
    Node* data;
    int front, rear, size;
}Queue;

void initQueue(Queue* queue, int capacity){
    queue->data = (Node*)malloc(sizeof(Node) * capacity);
    queue->front = queue->rear = 0;
    queue->size = capacity;
}

int isEmpty(Queue* queue){
    return queue->front == queue->rear;
}

void enqueue(Queue* queue, Node item){
    queue->data[queue->rear++] = item;
}

Node dequeue(Queue* queue){
    return queue->data[queue->front++];
}

int main(){
    int row_size, column_size;
    scanf("%d %d", &row_size, &column_size);

    int** graph = (int**)malloc((row_size + 2) * sizeof(int*));
    int** result = (int**)malloc((row_size + 2) * sizeof(int*));
    for(int i = 0; i < row_size + 2; i++){
        graph[i] = (int*)calloc(column_size + 2, sizeof(int));
        result[i] = (int*)calloc(column_size + 2, sizeof(int));
    }

    for(int i = 1; i <= row_size; i++){
        char row[105];
        scanf("%s", row);
        for(int j = 1; j <= column_size; j++){
            graph[i][j] = row[j - 1] - '0';
        }
    }

    Queue queue;
    initQueue(&queue, (row_size + 2) * (column_size + 2));
    enqueue(&queue, (Node){1, 1, 1});
    result[1][1] = 1;

    while(!isEmpty(&queue)){
        Node cur = dequeue(&queue);
        int x = cur.x, y = cur.y, distance = cur.distance;

        if(graph[x + 1][y] && !result[x + 1][y]){
            enqueue(&queue, (Node){x + 1, y, distance + 1});
            result[x + 1][y] = distance + 1;
        }
        if(graph[x - 1][y] && !result[x - 1][y]){
            enqueue(&queue, (Node){x - 1, y, distance + 1});
            result[x - 1][y] = distance + 1;
        }
        if(graph[x][y + 1] && !result[x][y + 1]){
            enqueue(&queue, (Node){x, y + 1, distance + 1});
            result[x][y + 1] = distance + 1;
        }
        if(graph[x][y - 1] && !result[x][y - 1]){
            enqueue(&queue, (Node){x, y - 1, distance + 1});
            result[x][y - 1] = distance + 1;
        }
    }

    printf("%d\n", result[row_size][column_size]);

    for(int i = 0; i < row_size + 2; i++){
        free(graph[i]);
        free(result[i]);
    }
    free(graph);
    free(result);
    free(queue.data);
    return 0;
}