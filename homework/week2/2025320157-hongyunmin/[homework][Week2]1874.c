#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef struct{
    int top;
    int max_size;
    int* data;
}Stack;

void init_stack(Stack *, int);
int push(Stack *, int);
int pop(Stack *);
int peek(Stack *);
int isEmpty(Stack *);
int isFull(Stack *);

int main(){
    int n, k, num = 1, is_valid_sequence = 1;
    Stack stack;
    char result[400001] = "";

    scanf("%d", &n);
    init_stack(&stack, n);

    for(int i = 0; i < n; i++){
        scanf("%d", &k);
        if(num <= k){
            while(num <= k){
                push(&stack, num++);
                strcat(result, "+\n");
            }
            pop(&stack);
            strcat(result, "-\n");
        }
        else{
            if(peek(&stack) > k){
                is_valid_sequence = 0;
                printf("NO");
                exit(0);
            }
            else{
                pop(&stack);
                strcat(result, "-\n");
            }
        }
    }
    if(is_valid_sequence){
        printf("%s", result);
    }

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
int peek(Stack *stack){
    return stack->data[stack->top];
}
int isEmpty(Stack *stack){
    return stack->top == -1;
}
int isFull(Stack *stack){
    return stack->top == stack->max_size - 1;
}