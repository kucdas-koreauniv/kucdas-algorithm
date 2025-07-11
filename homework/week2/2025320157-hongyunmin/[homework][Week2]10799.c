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
int isEmpty(Stack *);
int isFull(Stack *);

int main(){
    Stack stack;
    char vps[100001] = "";
    int count = 0;
    scanf("%s", vps);
    
    int len_vps = strlen(vps);

    init_stack(&stack, strlen(vps));

    for(int i = 0; i < len_vps; i++){
        if(vps[i] == '('){
            if(vps[i + 1] == ')'){
                count += stack.top + 1;
                i++;
            }
            else{
                push(&stack, '(');
            }
        }
        else{
            pop(&stack);
            count++;
        }
    }
    printf("%d", count);

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