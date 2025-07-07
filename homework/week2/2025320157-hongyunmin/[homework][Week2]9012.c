#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef struct{
    int top;
    int max_size;
    int* data;
}Stack;

void init_stack(Stack *, int);
void push(Stack *, int);
int pop(Stack *);
int isEmpty(Stack *);
int isFull(Stack *);

int main(){
    int n;
    scanf("%d", &n);
    
    for(int i = 0; i < n; i++){
        Stack stack;
        char vps[50] = "";
        int flag = 1;
        scanf("%s", vps);
        init_stack(&stack, strlen(vps));

        for(int j = 0; j < strlen(vps); j++){
            if(vps[j] == '(') push(&stack, '(');
            else{
                if(isEmpty(&stack)){
                    flag = 0;
                    break;
                }
                else pop(&stack);
            }
        }
        if(flag && isEmpty(&stack)) printf("YES\n");
        else printf("NO\n");

        free(stack.data);
    }
}

void init_stack(Stack *stack, int n){
    stack->data = (int *)malloc(sizeof(int) * n);
    stack->top = -1;
    stack->max_size = n;
}
void push(Stack *stack, int n){
    if(isFull(stack)){
        printf("Stack overflow");
        return;
    }
    stack->data[++stack->top] = n;
}
int pop(Stack *stack){
    if(isEmpty(stack)){
        printf("Empty stack");
        return -1;
    }
    return stack->data[stack->top--];
}
int isEmpty(Stack *stack){
    if(stack->top == -1) return 1;
    else return 0;
}
int isFull(Stack *stack){
    if(stack->top == stack->max_size - 1) return 1;
    else return 0;
}