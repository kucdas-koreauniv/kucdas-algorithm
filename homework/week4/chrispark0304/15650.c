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

void permutation(int N, int M, int printed_arr[], int depth){
    if(depth == M){
        print_arr(printed_arr, M);
        return;
    }
    int start;
    if (depth == 0) {
        start = 1;
    } else {
        start = printed_arr[depth - 1] + 1;
    }
    for(int i = start ; i <= N ; i++){
        printed_arr[depth] = i;
        permutation(N, M, printed_arr, depth+1);
        printed_arr[depth] = 0;
        
    }
}
int main(){
    int max_num, arr_length;

    scanf("%d %d",&max_num, &arr_length);
    
    //int* arr_isused = (int*)malloc(sizeof(int)*(max_num+1)); //0~7까지면 8자리 -> arr_isused[1]: 1의 사용여부
    int* printed_arr = (int*)malloc(sizeof(int)*arr_length);

    permutation(max_num, arr_length, printed_arr, 0);

    //free(arr_isused);
    free(printed_arr);
}