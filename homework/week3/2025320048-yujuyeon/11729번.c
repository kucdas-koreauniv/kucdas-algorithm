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

void print_hanoi(int n) {
    static int current = 1;
    static int medium = 2;
    static int dest = 3;
    if (n == 1) {
        printf("%d %d\n", current, dest);
    }
    else if (n == 2) {
        printf("%d %d\n", current, medium);
        printf("%d %d\n", current, dest);

        swap(&current, &medium);
        print_hanoi(n - 1);
        swap(&current, &medium);
    }
    else {
        swap(&medium, &dest);
        print_hanoi(n - 1);
        swap(&medium, &dest);
       
        printf("%d %d\n", current, dest);

        swap(&current, &medium);
        print_hanoi(n - 1);
        swap(&current, &medium);
    }
}

int main(void) {
    int n;
    scanf("%d", &n);
    printf("%d\n", count_hanoi(n));
    print_hanoi(n);

    return 0;
}