#include<stdio.h>
#include<stdlib.h>

typedef struct{
    int height;
    int index;
}Value;

typedef struct{
    int top;
    int max_size;
    Value* data;
}Stack;

void init_stack(Stack *, int);
void push(Stack *, Value);
void pop(Stack *);
Value peek(Stack *);
int isEmpty(Stack *);
int isFull(Stack *);

int main(){
    int n;
    scanf("%d", &n);
    while(n > 0){
        long long int max = 0, k, area, h;
        Stack stack;

        init_stack(&stack, n + 2);
        push(&stack, (Value){0, 0});
        
        for(int i = 1; i <= n; i++){
            scanf("%lld", &k);

            while(!isEmpty(&stack) && peek(&stack).height > k){
                h = peek(&stack).height;
                pop(&stack);
                area = h * (i - peek(&stack).index - 1);
                max = max > area ? max : area;
            }

            push(&stack, (Value){k, i});
        }

        while(peek(&stack).height > 0){
            h = peek(&stack).height;
            pop(&stack);
            area = h * (n - peek(&stack).index);
            max = max > area ? max : area;
        }

        printf("%lld\n", max);
        free(stack.data);
        
        scanf("%d", &n);
    }

    return 0;
}

void init_stack(Stack *stack, int n){
    stack->data = (Value *)malloc(sizeof(Value) * n);
    stack->top = -1;
    stack->max_size = n;
}
void push(Stack *stack, Value value){
    stack->data[++stack->top] = value;
}
void pop(Stack *stack){
    if(!isEmpty(stack)){
        stack->top--;
    }
}
Value peek(Stack *stack){
    return stack->data[stack->top];
}
int isEmpty(Stack *stack){
    return stack->top == -1;
}
int isFull(Stack *stack){
    return stack->top == stack->max_size - 1;
}