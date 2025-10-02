#include<stdio.h>
#include<stdlib.h>

void dfs(int** graph, int* visited, int vertex, int size_graph){
    if(visited[vertex]){
        return;
    }
    visited[vertex] = 1;
    for(int i = 1; i < size_graph; i++){
        if(graph[vertex][i]){
            dfs(graph, visited, i, size_graph);
        }
    }
}

int main(){
    int num_com, num_node;
    scanf("%d\n%d", &num_com, &num_node);

    int* visited = (int*)calloc(num_com + 1, sizeof(int));
    int** graph = (int**)malloc((num_com + 1) * sizeof(int*));
    for(int i = 0; i < num_com + 1; i++){
        graph[i] = (int*)calloc(num_com + 1, sizeof(int));
    }

    for(int i = 0; i < num_node; i++){
        int v_a, v_b;
        scanf("%d %d", &v_a, &v_b);
        graph[v_a][v_b] = 1;
        graph[v_b][v_a] = 1;
    }

    dfs(graph, visited, 1, num_com + 1);

    int result = 0;
    for(int i = 2; i < num_com + 1; i++){
        result += visited[i];
    }
    printf("%d", result);

    free(visited);
    for(int i = 0; i < num_com + 1; i++){
        free(graph[i]);
    }
    free(graph);
    return 0;
}