#include <stdio.h>
#define MAX 100

int stack[MAX];
int top = -1;

void push(int x) {
    if (top < MAX - 1) {
        stack[++top] = x;
    }
}

int pop() {
    if (top >= 0) {
        return stack[top--];
    }
    return -1;
}

int peek() {
    if (top >= 0) {
        return stack[top];
    }
    return -1;
}

int is_empty() {
    return top == -1;
}

int is_full() {
    return top == MAX - 1;
}

int main() {
    push(10);
    push(20);
    printf("%d\n", pop());
    printf("%d\n", peek());
    return 0;
}
