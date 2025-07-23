#include <stdio.h>
void swap(int* a, int* b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

int count_hanoi(int n) {
    static int count = 0;
    if (n == 1) {
        count++;
    }
    else if (n == 2) {
        count++;
        count++;
        count_hanoi(n - 1);
    }
    else {
        count_hanoi(n - 1);
        count++;
        count_hanoi(n - 1);
    }
    return count;
}

void print_hanoi(int n, int current, int medium, int dest) {
    if (n == 1) {
        printf("%d %d\n", current, dest);
    }
    else if (n == 2) {
        printf("%d %d\n", current, medium);
        printf("%d %d\n", current, dest);

        swap(&current, &medium);
        print_hanoi(n - 1, current, medium, dest);
        swap(&current, &medium);
    }
    else {
        swap(&medium, &dest);
        print_hanoi(n - 1, current, medium, dest);
        swap(&medium, &dest);
       
        printf("%d %d\n", current, dest);

        swap(&current, &medium);
        print_hanoi(n - 1, current, medium, dest);
        swap(&current, &medium);
    }
}

int main(void) {
    int current = 1;
    int medium = 2;
    int dest = 3;
    int n;
    scanf("%d", &n);
    printf("%d\n", count_hanoi(n));
    print_hanoi(n, current, medium, dest);

    return 0;
}