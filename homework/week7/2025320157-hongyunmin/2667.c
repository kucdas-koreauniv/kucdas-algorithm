#include<stdio.h>
#include<stdlib.h>

int dfs(int** map, int x, int y){
    int sum = 1;
    map[x][y] = 0;
    if(map[x + 1][y]){
        sum += dfs(map, x + 1, y);
    }
    if(map[x - 1][y]){
        sum += dfs(map, x - 1, y);
    }
    if(map[x][y + 1]){
        sum += dfs(map, x, y + 1);
    }
    if(map[x][y - 1]){
        sum += dfs(map, x, y - 1);
    }
    return sum;
}

int cmp(const void* a, const void* b){
    return (*(int*)a - *(int*)b);
}

int main(){
    int size_map;
    scanf("%d", &size_map);

    int** map = (int**)malloc((size_map + 2) * sizeof(int*));
    for(int i = 0; i < size_map + 2; i++){
        map[i] = (int*)calloc(size_map + 2, sizeof(int));
    }

    for(int i = 1; i < size_map + 1; i++){
        for(int j = 1; j < size_map + 1; j++){
            scanf("%1d", &map[i][j]);
        }
    }


    
    int num_complex = 0;
    int* num_house = (int*)malloc(size_map * size_map * sizeof(int));
    for(int i = 1; i < size_map + 1; i++){
        for(int j = 1; j < size_map + 1; j++){
            if(map[i][j]){
                num_house[num_complex] = dfs(map, i, j);
                num_complex++;
            }
        }
    }

    qsort(num_house, num_complex, sizeof(int), cmp);
    printf("%d\n", num_complex);
    for(int i = 0; i < num_complex; i++){
        printf("%d\n", num_house[i]);
    }

    free(num_house);
    for(int i = 0; i < size_map + 2; i++){
        free(map[i]);
    }
    free(map);
    return 0;
}