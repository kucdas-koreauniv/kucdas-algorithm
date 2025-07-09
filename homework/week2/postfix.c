#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#define MAX 100

int stack[MAX];
int top;

void push(int x) {
    if (top == MAX-1){ 
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
int Operation(int a, int b, char op) {
    switch (op) {
        case '+': return a + b;
        case '-': return a - b;
        case '*': return a * b;
        case '/': return b ? a / b : (printf("잘못된 계산입니다."), 0);
        default:  printf("잘못된 입력입니다."); return 0;
    }
}

int main(void) {
    top = -1;
    char line[256];
    if (!fgets(line, sizeof(line), stdin)) return 0;
    line[strcspn(line, "\n")] = '\0';
    char *tok = strtok(line, " ");
    while (tok) {
        if (isdigit(tok[0]) || (tok[0]=='-' && isdigit(tok[1]))) {
            push(atoi(tok));
        }
        else if (strlen(tok)==1 && strchr("+-*/", tok[0])) {
            int b = pop(), a = pop();
            push(Operation(a, b, tok[0]));
        }
        else {
            fprintf(stderr, "잘못된 입력: %s\n", tok);
            return 1;
        }
        tok = strtok(NULL, " ");
    }
    if (top == 0)
        printf("%d\n", pop());
    else
        printf("잘못된 후위 표기식");
    return 0;
}
