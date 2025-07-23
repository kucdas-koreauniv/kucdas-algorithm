#include <stdio.h>
void concat(int arr[], int void_idx, int* len) { 
    for (int i = 0; void_idx + i < (*len) - 1; i++) {
        arr[void_idx + i] = arr[void_idx + i + 1]; 
    }
    (*len)--;
    return;
} 
// (1 ≤ K ≤ N ≤ 1,000) 라는 조건이 있어서 시간복잡도가 O(N^2)임에도 충분할거라고 생각했었음.
// 더 높은 티어의(조건이 타이트한) 문제를 풀때는 원형 큐를 이용해야겠다...
int main(void) {
    int arr[1001];
    int josep[1001];
    int n, kth;
    int first = 0;
    scanf("%d %d", &n, &kth);
    int len = n;
    for (int i = 0; i < n; i++) {
        arr[i] = i + 1;
    }

    for (int i = 0; i < n; i++) {
        josep[i] = arr[(first + kth - 1) % len];
        arr[(first + kth - 1) % len] = -1;
        
        first = (first + kth - 1) % len;
        concat(arr, first, &len); 
    }
    printf("<");
    for (int i = 0; i < n - 1; i++) {
        printf("%d, ", josep[i]);
    }
    printf("%d", josep[n - 1]);
    printf(">");

    return 0;
}