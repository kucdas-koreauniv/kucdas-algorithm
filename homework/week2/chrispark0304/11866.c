#include <stdio.h>
#include <stdlib.h>

int main(){
    int people[1000000] = {0,};
    int n,k;
    scanf("%d %d",&n,&k);


    int start = 0;
    int end = n;

    for(int i = 0 ; i < n ; i++){
        people[i] = i+1;
    }
    printf("<");
    while(start != end){
        for(int i = 1 ; i < k ; i++){
            people[end] = people[start];
            start++;
            end++;
        }
        if(end - start == 1)break;
        printf("%d, ", people[start]);
        start++;
    }
    printf("%d>",people[start]);
}