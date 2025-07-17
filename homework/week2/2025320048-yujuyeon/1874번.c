#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define MAX_SIZE 200001

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
Stack in_stack;
Stack out_stack;
Stack output;
int main(void) {
    
    init(&in_stack);
    init(&out_stack);
    init(&output);
    int is_possible = 1;
    int n;
    scanf("%d", &n);
    int input[100001];
    int push_num = 0;

    for (int i = 0; i < n; i++) {
        scanf("%d", &input[i]);
        
        if (input[i] < input[i-1] && input[i] == in_stack.data[in_stack.top]) {
            push(&out_stack, in_stack.data[in_stack.top]); // 팝
            pop(&in_stack);
        
            push(&output, '-');
        }

        else if (input[i] > push_num) {
            int diff = input[i] - push_num;
            for (int j = 0; j < diff; j++) {
                push(&in_stack, ++push_num); // 푸시 m번

                push(&output, '+');
            }
            push(&out_stack, in_stack.data[in_stack.top]); // 팝 1번
            pop(&in_stack);

            push(&output, '-');
        }

        else {
            is_possible = 0;
        }
    }
    switch (is_possible) {
        case 1:
            for (int i = 0; i <= output.top; i++) {
                printf("%c\n", output.data[i]);
            }
            break;
        case 0:
            printf("NO");
            break;
    }

    return 0;
}