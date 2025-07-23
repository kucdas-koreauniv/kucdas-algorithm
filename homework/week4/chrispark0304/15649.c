#include <stdio.h>
#include <stdlib.h>
#include <string.h>
void print_arr(int arr[], int len){
    for(int i = 0 ; i < len ; i++){
        if(i == len - 1){
            printf("%d\n", arr[i]);
        }
        else{
            printf("%d ",arr[i]);
        }
    }
}

void permutation(int arr_isused[], int size_arr_isused, int printed_arr[], int size_printed_arr, int depth, int curr_depth){
    if(depth == curr_depth){
        for(int i = 1 ; i < size_arr_isused ; i++){
            if(arr_isused[i] != 0) continue;
            else{
                printed_arr[curr_depth] = i;
                print_arr(printed_arr, size_printed_arr);
            }
        }
    }
    else{
        for(int i = 1 ; i < size_arr_isused ; i++){
            if(arr_isused[i] != 0) continue;
            else{
                printed_arr[curr_depth] = i;
                arr_isused[i] = 1;
                permutation(arr_isused, size_arr_isused, printed_arr, size_printed_arr, depth, curr_depth+1);
                arr_isused[i] = 0;
                printed_arr[curr_depth] = 0;
            }
        }
    }
}


int main(){
    int max_num, arr_length;

    scanf("%d %d",&max_num, &arr_length);
    
    int* arr_isused = (int*)malloc(sizeof(int)*(max_num+1)); //0~7까지면 8자리 -> arr_isused[1]: 1의 사용여부
    int* printed_arr = (int*)malloc(sizeof(int)*arr_length);

    permutation(arr_isused, max_num+1 ,printed_arr, arr_length, arr_length - 1, 0);
}