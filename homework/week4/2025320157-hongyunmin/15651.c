#include<stdio.h>

int nums[9];
int max_num, size;

void permutation(int index){
    if(index == size){
        for(int i = 0; i < size; i++){
            printf("%d ", nums[i]);
        }
        printf("\n");
        return;
    }
    for (int i = 1; i <= max_num; i++){
    	nums[index] = i;
    	permutation(index + 1);
	}
}

int main(){
    scanf("%d %d", &max_num, &size);
    permutation(0);

    return 0;
}