#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef struct{
    int value;
    int child;
}Paren;

typedef struct{
    int top;
    int max_size;
    Paren* data;
}Stack;

void init_stack(Stack *, int);
void push(Stack *, Paren);
Paren pop(Stack *);
Paren peek(Stack *);
int isEmpty(Stack *);
int isFull(Stack *);

int main(){
    Stack stack;
    char paren_str[31] = "";
    int is_valid_paren = 1, result = 0;
    
    scanf("%s", paren_str);
    int paren_len = strlen(paren_str);
    init_stack(&stack, paren_len);

    for(int i = 0; i < paren_len; i++){
        if(paren_str[i] == '('){
            push(&stack, (Paren){'(', 1});
        }
        else if(paren_str[i] == '['){
            push(&stack, (Paren){'[', 1});
        }
        else if(paren_str[i] == ')'){
            if(peek(&stack).value != '('){
                is_valid_paren = 0;
                break;
            }
            if(stack.top == 0){
                result += pop(&stack).child * 2;
            }
            else{
                int tmp = pop(&stack).child * 2;
                if(stack.data[stack.top].child == 1){
                    stack.data[stack.top].child = tmp;
                }
                else{
                    stack.data[stack.top].child += tmp;
                }
            }
        }
        else{
            if(peek(&stack).value != '['){
                is_valid_paren = 0;
                break;
            }
            if(stack.top == 0){
                result += pop(&stack).child * 3;
            }
            else{
                int tmp = pop(&stack).child * 3;
                if(stack.data[stack.top].child == 1){
                    stack.data[stack.top].child = tmp;
                }
                else{
                    stack.data[stack.top].child += tmp;
                }
            }
        }
    }
    
    if(is_valid_paren && isEmpty(&stack)){
        printf("%d", result);
    }
    else{
        printf("0");
    }

    free(stack.data);
    return 0;
}

void init_stack(Stack *stack, int n){
    stack->data = (Paren *)malloc(sizeof(Paren) * n);
    stack->top = -1;
    stack->max_size = n;
}
void push(Stack *stack, Paren paren){
    stack->data[++stack->top] = paren;
}
Paren pop(Stack *stack){
    return stack->data[stack->top--];
}
Paren peek(Stack *stack){
    return stack->data[stack->top];
}
int isEmpty(Stack *stack){
    return stack->top == -1;
}
int isFull(Stack *stack){
    return stack->top == stack->max_size - 1;
}