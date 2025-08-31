#include<stdio.h>
#include<stdlib.h>

int z(int size, int row, int column){
	if(size == 0) return 0;
	
	int half = 1 << (size - 1);
	int square = half * half;
	
	if(row < half && column < half) return z(size - 1, row, column);
	else if(row < half) return square + z(size - 1, row, column - half);
	else if(column < half) return 2 * square + z(size - 1, row - half, column);
	else return 3 * square + z(size - 1, row - half, column - half);
}

int main(){
	int size, row, column;
	scanf("%d %d %d", &size, &row, &column);
	
	printf("%d", z(size, row, column));
}