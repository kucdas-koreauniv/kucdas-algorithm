#include <stdio.h>
void concat(int arr[], int void_idx, int* len) {
    for (int i = 0; void_idx + i < (*len) - 1; i++) {
        arr[void_idx + i] = arr[void_idx + i + 1]; 
    }
    (*len)--;
    return;
}
int main(void) {
    int arr[1001];
    int josep[1001];
    int n, k;
    int first = 0;
    scanf("%d %d", &n, &k);
    int len = n;
    for (int i = 0; i < n; i++) {
        arr[i] = i + 1;
    }

    for (int i = 0; i < n; i++) {
        josep[i] = arr[(first + k - 1) % len];
        arr[(first + k - 1) % len] = -1;
        
        first = (first + k - 1) % len;
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