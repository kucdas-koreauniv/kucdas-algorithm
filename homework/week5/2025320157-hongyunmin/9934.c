#include<stdio.h>
#include<stdlib.h>

void copy_array(int* arr, int* new, int start_index, int new_size){
    for(int i = 0; i < new_size; i++){
        new[i] = arr[i + start_index];
    }
}

void perfect_binary_tree(int* tree, int size_tree, int* result, int index){
    if(size_tree == 1){
        result[index] = tree[0];
        return;
    }
    int* left_sub = (int*)malloc(sizeof(int) * size_tree / 2);
    int* right_sub = (int*)malloc(sizeof(int) * size_tree / 2);
    int root_index = size_tree / 2;
    copy_array(tree, left_sub, 0, size_tree / 2);
    copy_array(tree, right_sub, size_tree / 2 + 1, size_tree / 2);
    
    result[index] = tree[root_index];
    perfect_binary_tree(left_sub, size_tree / 2, result, index * 2);
    perfect_binary_tree(right_sub, size_tree / 2, result, index * 2 + 1);
}

int main(){
    int power;
    scanf("%d", &power);
    int size_tree = (1 << power) - 1;
    int* result = (int*)malloc(sizeof(int) * (size_tree + 1));
    int* tree = (int*)malloc(sizeof(int) * size_tree);
    for(int i = 0; i < size_tree; i++){
        scanf("%d", &tree[i]);
    }

    perfect_binary_tree(tree, size_tree, result, 1);

    for(int i = 0; i < power; i++){
        for(int j = 1 << i; j < 1 << (i + 1); j++){
            printf("%d ", result[j]);
        }
        printf("\n");
    }

    free(result);
    free(tree);
    return 0;
}