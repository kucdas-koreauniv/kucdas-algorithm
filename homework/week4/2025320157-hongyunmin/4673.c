#include<stdio.h>

int self_sum(int num){
    int sum = num;
    while(num != 0){
        sum += num % 10;
        num /= 10;
    }
    return sum;
}

void self_num(int nums[], int num){
    int sum_num = self_sum(num);
    if(sum_num > 10000 || nums[sum_num]){
        return;
    }
    nums[sum_num] = 1;
    self_num(nums, sum_num);
}

int main(){
    int nums[10001] = {0};
    for(int i = 1; i <= 10000; i++){
        if(!nums[i]){
            self_num(nums, i);
        }
    }
    for(int i = 1; i <= 10000; i++){
        if(!nums[i]){
            printf("%d\n", i);
        }
    }
    
    return 0;
}