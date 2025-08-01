#include<stdio.h>
#include<stdlib.h>

int result = 0;

int is_leaf(int** graph, int node, int size_graph){
    for(int i = 0; i < size_graph; i++){
        if(graph[node][i]){
            return 0;
        }
    }
    return 1;
}

void dfs(int** graph, int node, int size_graph){
    if(is_leaf(graph, node, size_graph)){
        result++;
        return;
    }
    for(int i = 0; i < size_graph; i++){
        if(graph[node][i]){
            graph[i][node] = 0;
            graph[node][i] = 0;
            dfs(graph, i, size_graph);
        }
    }
}

int main(){
    int num_node, root;
    scanf("%d", &num_node);

    int** graph = (int**)malloc(num_node * sizeof(int*));
    for(int i = 0; i < num_node; i++){
        graph[i] = (int*)calloc(num_node, sizeof(int));
    }
    
    for(int i = 0; i < num_node; i++){
        int node;
        scanf("%d", &node);
        if(node == -1){
            root = i;
        }
        else{
            graph[i][node] = 1;
            graph[node][i] = 1;
        }
    }
    
    int delete_node;
    scanf("%d", &delete_node);
    for(int i = 0; i < num_node; i++){
        graph[delete_node][i] = 0;
        graph[i][delete_node] = 0;
    }

    if(delete_node != root){
        dfs(graph, root, num_node);
    }
    printf("%d", result);

    for(int i = 0; i < num_node; i++){
        free(graph[i]);
    }
    free(graph);

    return 0;
}