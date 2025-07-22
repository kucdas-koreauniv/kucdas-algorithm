#include <stdio.h>
#define MAX 100

int stack[MAX];
int top;

void push(int x){
    if (top == MAX - 1){
        printf("스택 오버플로우\n");
        return;
    }
    stack[++top] = x;
}

int pop(){
    if (top == -1){
        printf("스택 언더플로우\n");
        return 0;
    }
    return stack[top--];
} 

int peek(){
    if (top == -1) {
        printf("스택 언더플로우\n");
        return 0; 
    }
    return stack[top];

}
int isEmpty(){
    return top == -1;
}

int isFull(){
    return top == MAX - 1;
}

int stackSize(){
    return top + 1;
}

//테스트
int main(){
    top = - 1;
    push(10);
    printf("peek = %d, size = %d\n", peek(), stackSize());  
    push(20);
    printf("peek = %d, size = %d\n", peek(), stackSize());  
    printf("pop = %d, pop = %d\n", pop(), pop());   
    printf("empty? %d\n", isEmpty());    
    return 0;
}