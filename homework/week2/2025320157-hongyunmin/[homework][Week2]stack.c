#include<stdio.h>
#include<stdlib.h>

typedef struct{
    int top;
    int max_size;
    int* data;
}Stack;

void init_stack(Stack *, int);
int push(Stack *, int);
int pop(Stack *);
int isEmpty(Stack *);
int isFull(Stack *);

int main(){
    Stack stack;
    init_stack(&stack, 10);

    printf("%d\n", isEmpty(&stack));
    push(&stack, 1);
    push(&stack, 2);
    printf("%d\n", pop(&stack));
    push(&stack, 3);
    push(&stack, 4);
    push(&stack, 5);
    push(&stack, 6);
    push(&stack, 7);
    push(&stack, 8);
    push(&stack, 9);
    push(&stack, 10);
    push(&stack, 11);
    printf("%d\n", isFull(&stack));
    printf("%d\n", isEmpty(&stack));
    printf("%d\n", pop(&stack));

    free(stack.data);

    return 0;
}

void init_stack(Stack *stack, int n){
    stack->data = (int *)malloc(sizeof(int) * n);
    stack->top = -1;
    stack->max_size = n;
}
int push(Stack *stack, int n){
    if(isFull(stack)){
        return 1;
    }
    stack->data[++stack->top] = n;
    return 0;
}
int pop(Stack *stack){
    if(isEmpty(stack)){
        printf("Empty stack");
        return -1;
    }
    return stack->data[stack->top--];
}
int isEmpty(Stack *stack){
    return stack->top == -1;
}
int isFull(Stack *stack){
    return stack->top == stack->max_size - 1;
}