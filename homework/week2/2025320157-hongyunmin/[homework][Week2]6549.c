<<<<<<< HEAD
//백준 6549 (히스토그램에서 가장 큰 직사각형)

=======
>>>>>>> 2f031c9 (2504, 6549 피드백 수용)
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
<<<<<<< HEAD
    while(1){
        int num_value;
        scanf("%d", &num_value);
        if(num_value == 0){
            break;
        }

        long long int max = 0, value, rect_area, rect_height;
        Stack stack;

        init_stack(&stack, num_value + 2);
        push(&stack, (Value){0, 0});
        
        for(int i = 1; i <= num_value; i++){
            scanf("%lld", &value);

            while(peek(&stack).height > value){
                rect_height = peek(&stack).height;
                pop(&stack);
                rect_area = rect_height * (i - peek(&stack).index - 1);
                max = max > rect_area ? max : rect_area;
            }

            push(&stack, (Value){value, i});
        }

        while(peek(&stack).height > 0){
            rect_height = peek(&stack).height;
            pop(&stack);
            rect_area = rect_height * (num_value - peek(&stack).index);
            max = max > rect_area ? max : rect_area;
=======
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
>>>>>>> 2f031c9 (2504, 6549 피드백 수용)
        }

        printf("%lld\n", max);
        free(stack.data);
<<<<<<< HEAD
=======
        
        scanf("%d", &n);
>>>>>>> 2f031c9 (2504, 6549 피드백 수용)
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