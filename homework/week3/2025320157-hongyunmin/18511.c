#include<stdio.h>
#include<stdlib.h>

int result = 0, target_num, num_element;
int element[3];

void find_num(int num){
    if(target_num < num){
        return;
    }
    if(result < num){
        result = num;
    }
    
    num *= 10;
    for(int i = 0; i < num_element; i++){
        find_num(num + element[i]);
    }
}

int main(){
    scanf("%d %d", &target_num, &num_element);
    for(int i = 0; i < num_element; i++){
        scanf("%d", &element[i]);
    }

    find_num(0);
    
    printf("%d", result);

    return 0;
}