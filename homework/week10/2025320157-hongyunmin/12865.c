#include<stdio.h>

typedef struct Item{
	int weight;
	int value;
}Item;

int main(){
	int num_item, max_w;
    scanf("%d %d", &num_item, &max_w);

    Item item[100] = {};
    for(int i = 0; i < num_item; i++){
        scanf("%d %d", &item[i].weight, &item[i].value);
    }
    int dp[100001] = {};

	for(int i = 0; i < num_item; i++){
		for(int w = max_w; w >= item[i].weight; w--){
            int a = dp[w]; //물건을 넣지 않는 경우
            int b = item[i].value + dp[w - item[i].weight]; //물건을 넣는 경우
            dp[w] = a > b ? a : b;
		}
	}
    printf("%d", dp[max_w]);

    return 0;
}