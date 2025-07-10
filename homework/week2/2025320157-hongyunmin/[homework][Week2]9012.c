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
    int testcase;
    scanf("%d", &testcase);
    
    for(int i = 0; i < testcase; i++){
        Stack stack;
        char vps[50] = "";
        int is_valid_paren = 1;
        scanf("%s", vps);
        init_stack(&stack, strlen(vps));

        for(int j = 0; j < strlen(vps); j++){
            if(vps[j] == '('){
                push(&stack, '(');
            }
            else{
                if(isEmpty(&stack)){
                    is_valid_paren = 0;
                    break;
                }
                else pop(&stack);
            }
        }
        if(is_valid_paren && isEmpty(&stack)){
            printf("YES\n");
        }
        else{
            printf("NO\n");
        }

        free(stack.data);
    }

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