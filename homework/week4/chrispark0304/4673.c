#include <stdio.h>

int self_num(int n){
    int self_n = n;
    while(n > 0){
        self_n += n % 10;
        n /= 10;
    }
    return self_n;
}

void find_self_num(int num_set[], int n){ //n에서부터 시작되는 d(n)을 10000이하에서 찾기
    int d = self_num(n);
    if(d > 10000){
        return;
    }
    num_set[self_num(n)] = 1;
    find_self_num(num_set , self_num(n));
}

int main(){
    int num_set[10001] = {0,};
    for(int i = 1 ; i <= 10000 ; i++){
        find_self_num(num_set , i);
    }
    for(int i = 1 ; i <= 10000 ; i++){
        if(num_set[i] == 0){
            printf("%d\n", i);
        }
    }

    return 0;
}