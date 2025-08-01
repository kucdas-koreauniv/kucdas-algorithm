#include<stdio.h>
#include<stdlib.h>

typedef struct Node {
    int vertex;
    struct Node* next;
}Node;

void add_edge(Node** graph, int node1, int node2){
    Node* temp = (Node*)malloc(sizeof(Node));
    temp->vertex = node2;
    temp->next = graph[node1];
    graph[node1] = temp;
}

void dfs(Node** graph, int* visited, int* parents, int node){
    visited[node] = 1;
    for(Node* now = graph[node]; now != NULL; now = now->next){
        int next = now->vertex;
        if(!visited[next]){
            parents[next] = node;
            dfs(graph, visited, parents, next);
        }
    }
}

int main(){
    int num_node;
    scanf("%d", &num_node);

    int* visited = (int*)calloc(num_node + 1, sizeof(int));
    int* parents = (int*)calloc(num_node + 1, sizeof(int));
    Node** graph = (Node**)calloc(num_node + 1, sizeof(Node*));

    for(int i = 1; i < num_node; i++){
        int node1, node2;
        scanf("%d %d", &node1, &node2);
        add_edge(graph, node1, node2);
        add_edge(graph, node2, node1);
    }

    dfs(graph, visited, parents, 1);
    for(int i = 2; i <= num_node; i++){
        printf("%d\n", parents[i]);
    }

    for(int i = 0; i <= num_node; i++){
        Node* now = graph[i];
        while(now != NULL){
            Node* temp = now;
            now = now->next;
            free(temp);
        }
    }
    free(graph);
    free(visited);

    return 0;
}