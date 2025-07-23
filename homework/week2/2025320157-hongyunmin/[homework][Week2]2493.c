#include<stdio.h>
#include<stdlib.h>

typedef struct{
    int height;
    int index;
}Top;

typedef struct{
    int top;
    int max_size;
    Top* data;
}Stack;

void init_stack(Stack *, int);
void push(Stack *, Top);
Top peek(Stack *);
void pop(Stack *);
int isEmpty(Stack *);
int isFull(Stack *);

int main(){
    Stack stack;
    int num_top, top_height;
    int *result;
    
    scanf("%d", &num_top);
    init_stack(&stack, num_top);
    result = (int *)malloc(sizeof(int) * num_top);

    for(int i = 0; i < num_top; i++){
        scanf("%d", &top_height);
        while(!isEmpty(&stack) && peek(&stack).height < top_height){
            pop(&stack);
        }
        if(isEmpty(&stack)){
            result[i] = 0;
        }
        else{
            result[i] = peek(&stack).index;
        }
        push(&stack, (Top){top_height, i + 1});

    }

    for(int i = 0; i < num_top; i++){
        printf("%d ", result[i]);
    }

    free(result);
    free(stack.data);
    return 0;
}

void init_stack(Stack *stack, int n){
    stack->data = (Top *)malloc(sizeof(Top) * n);
    stack->top = -1;
    stack->max_size = n;
}
void push(Stack *stack, Top top){
    stack->data[++stack->top] = top;
}
Top peek(Stack *stack){
    return stack->data[stack->top];
}
void pop(Stack *stack){
    if(!isEmpty(stack)){
        stack->top--;
    }
}
int isEmpty(Stack *stack){
    return stack->top == -1;
}
int isFull(Stack *stack){
    return stack->top == stack->max_size - 1;
}