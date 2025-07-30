#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct {
    int* data;
    int n;
    int top;
} Stack;

void init(Stack* s) {
    s->top = -1;
}

bool isEmpty(Stack* s) {
    return s->top == -1;
}

bool isFull(Stack* s) {
    return s->top == s->n - 1;
}

bool push(Stack* s, int value) {
    if (isFull(s)) {
        printf("스택 오버플로우!\n");
        return false;
    }
    s->data[++(s->top)] = value;
    return true;
}

bool pop(Stack* s) {
    if (isEmpty(s)) {
        printf("스택 언더플로우!\n");
        return false;
    }
    (s->top)--;
    return true;
}

void printStack(Stack* s) {
    for (int i = s->top; i >= 0; i--) {
        printf("%d ", s->data[i]);
    }
    printf("\n");
}
int main(void) {
    Stack s;
    init(&s);
    scanf("%d", &s.n);
    s.data = (int*)malloc(sizeof(int) * s.n);
}

