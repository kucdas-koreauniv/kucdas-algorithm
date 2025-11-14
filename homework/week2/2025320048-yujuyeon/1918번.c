#include <stdio.h>
#include <stdlib.h>
#include <string.h>
typedef struct {
    int* data;
    int n;
    int top;
} Stack;
void init(Stack* s, int stack_size) {
    s->n = stack_size;
    s->data = (int*)malloc(sizeof(int) * s->n);
    s->top = -1;
}
void push(Stack* s, int value) {
    if (s->top == s->n - 1) {
        //printf("스택 오버플로우!");
        return;
    }
    s->data[++(s->top)] = value;
}
int pop(Stack* s) {
    if (s->top == -1) {
        //printf("스택 언더플로우!");
        return -1;
    }
    return s->data[(s->top)--];
}

int find_left_operand_idx(char str[], int operator_idx) {
    int balance = 0;
    int left_operand_idx;
    for (int i = 1; str[operator_idx - i] != '\0'; i++) {
        if (str[operator_idx - i] == '(') {
            balance++;
        }
        else if (str[operator_idx - i] == ')') {
            balance--;
        }
        if (balance == 0) {
            return operator_idx - i;
        }
    }
    return -1;
}
int find_right_operand_idx(char str[], int operator_idx) {
    int balance = 0;
    for (int i = 1; str[operator_idx + i] != '\0'; i++) {
        if (str[operator_idx + i] == '(') {
            balance++;
        }
        else if (str[operator_idx + i] == ')') {
            balance--;
        }
        if (balance == 0) {
            return operator_idx + i;
        }
    }
    return -1; 
}

char* add_ps(char str[]) {
    // step0 (A) 이런 쓸데없는 괄호 제거하기
    int j = -1;
    char step0[1000];
    for (int i = 0; str[i] != '\0'; i++) {
        if (str[i] == '(' && str[i+2] == ')') {
            str[i] = '@';
            str[i+2] = '@';
        }
        if (str[i] != '@') {
            step0[++j] = str[i];
        }
    }
    step0[++j] = '\0';
    strcpy(str, step0);

    // step1 *, / )괄호 묶기
    char step1[1000];
    for (int i = 0; str[i] != '\0'; i++) {
        if (str[i] == '*' || str[i] == '/') {
            j = -1;
            for (int k = 0; str[k] != '\0'; k++) {
                if (k == find_left_operand_idx(str, i) && (str[find_left_operand_idx(str, i) - 1] != '(' || str[find_right_operand_idx(str, i) + 1] != ')')) {
                    step1[++j] = '(';
                }
                
                step1[++j] = str[k]; 
            
                if (k == find_right_operand_idx(str, i) && (str[find_left_operand_idx(str, i) - 1] != '(' || str[find_right_operand_idx(str, i) + 1] != ')')){
                    step1[++j] = ')';
                }
            }
            step1[++j] = '\0';
            strcpy(str, step1);
            i++;
        }
    }
    //step2 +,- )괄호
    char step2[1000];
    for (int i = 0; str[i] != '\0'; i++) {
        if (str[i] == '+' || str[i] == '-') {
            j = -1;
            for (int k = 0; str[k] != '\0'; k++) {
                
                if (k == find_left_operand_idx(str, i) && (str[find_left_operand_idx(str, i) - 1] != '(' || str[find_right_operand_idx(str, i) + 1] != ')')) {
                    step2[++j] = '(';
                }
                
                step2[++j] = str[k]; 
                
                if (k == find_right_operand_idx(str, i) && (str[find_left_operand_idx(str, i) - 1] != '(' || str[find_right_operand_idx(str, i) + 1] != ')')) { 
                    step2[++j] = ')';
                }
            }
            step2[++j] = '\0';
            strcpy(str, step2);
            i++;
        }
    }
    char* result = (char*)malloc(1001);
    strcpy(result, str);
    return result;
}
int main(void) {
    char input[1000];
    scanf("%s", input);
    char* change = add_ps(input); //char*을 반환하는 함수
    //printf("%s\n", change);
    Stack operator_stack;
    init(&operator_stack, 1000);
    for (int i = 0; change[i] != '\0'; i++) {
        if (change[i] >= 65 && change[i] <= 90) {
            printf("%c", change[i]);
        }
        else if (change[i] == '+' || change[i] == '-' || change[i] == '*' || change[i] == '/') {
            push(&operator_stack, change[i]);
        }
        else if (change[i] == ')') {
            if (operator_stack.top != -1) {
                printf("%c", operator_stack.data[operator_stack.top]);
                pop(&operator_stack);
            }
        }
    }
    
    return 0;
}