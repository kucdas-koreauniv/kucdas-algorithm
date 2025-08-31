#include <stdio.h>
#include <stdlib.h>

void star(int pattern_size, int **arr, int x, int y){
	if(pattern_size == 1){
		arr[x][y] = 1;
		return;
	}
	pattern_size /= 3;
	for(int i = 0; i < 3; i++)
		for(int j = 0; j < 3; j++)
			if (i * j != 1)
				star(pattern_size, arr, x + i * pattern_size, y + j * pattern_size);
}

int main(){
	int pattern_size;
	scanf("%d", &pattern_size);
	
	int **arr = (int **)calloc(pattern_size, sizeof(int *));
	for(int i = 0; i < pattern_size; i++)
		arr[i] = (int *)calloc(pattern_size, sizeof(int));
	
	star(pattern_size, arr, 0, 0);
	
	for(int i = 0; i < pattern_size; i++){
		for(int j = 0; j < pattern_size; j++){
			if(arr[i][j] == 1) printf("*");
			else printf(" ");
		}printf("\n");
	}
	
	for(int i = 0; i < pattern_size; i++)
		free(arr[i]);
	free(arr);
}