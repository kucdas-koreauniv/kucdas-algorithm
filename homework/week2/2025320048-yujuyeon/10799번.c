#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define MAX_SIZE 100002

typedef struct {
    int data[MAX_SIZE];
    int top;
} Stack;

void init(Stack* s) {
    s->top = -1;
}

bool isEmpty(Stack* s) {
    return s->top == -1;
}

bool isFull(Stack* s) {
    return s->top == MAX_SIZE - 1;
}

bool push(Stack* s, int value) {
    if (isFull(s)) {
        //printf("스택 오버플로우!\n");
        return false;
    }
    s->data[++(s->top)] = value;
    return true;
}

bool pop(Stack* s) {
    if (isEmpty(s)) {
        //printf("스택 언더플로우!\n");
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
    Stack input_stack;
    init(&input_stack);
    int count = 0;
    char input[100002];
    scanf("%s", input);

    for (int i = 0; input[i] != '\0'; i++) {
        if (input[i] == '(') {
            push(&input_stack, input[i]);
        }
        else if (input[i] == ')') {
            if (input[i-1] == '(') {
                pop(&input_stack);
                count += (input_stack.top + 1);
            }
            else {
                pop(&input_stack);
                count += 1;
            }
        }
    }
    printf("%d", count);

    return 0;
}