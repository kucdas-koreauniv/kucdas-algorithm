#include<stdio.h>

int hanoi(int num_disk){
	if(num_disk == 1) return 1;
	return(hanoi(num_disk - 1) * 2 + 1);
}

void print_hanoi(int num_disk, int a, int b){
	if(num_disk == 0) return;
	print_hanoi(num_disk - 1, a, 6 - a - b);
	printf("%d %d\n", a, b);
	print_hanoi(num_disk - 1, 6 - a - b, b);
}

int main(){
	int num_disk;
	scanf("%d", &num_disk);
	
	printf("%d\n", hanoi(num_disk));
	print_hanoi(num_disk, 1, 3);
}