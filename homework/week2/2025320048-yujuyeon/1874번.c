#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define MAX_SIZE 200001

typedef struct {
    int data[MAX_SIZE];
    int top;
} Stack;

void init(Stack* s) {
    s->top = -1;
}

bool isEmpty(Stack* s) {
    return s->top == -1;
}

bool isFull(Stack* s) {
    return s->top == MAX_SIZE - 1;
}

bool push(Stack* s, int value) {
    if (isFull(s)) {
        printf("스택 오버플로우!\n");
        return false;
    }
    s->data[++(s->top)] = value;
    return true;
}

bool pop(Stack* s) {
    if (isEmpty(s)) {
        printf("스택 언더플로우!\n");
        return false;
    }
    (s->top)--;
    return true;
}

void printStack(Stack* s) {
    for (int i = s->top; i >= 0; i--) {
        printf("%d ", s->data[i]);
    }
    printf("\n");
}
Stack in_s;
Stack out_s;
Stack output;
int main(void) {
    
    init(&in_s);
    init(&out_s);
    init(&output);
    int is_possible = 1;
    int n;
    scanf("%d", &n);
    int input[100001];
    int push_num = 0;
    for (int i = 0; i < n; i++) {
        scanf("%d", &input[i]);
        if (i == 0) {
            for (int j = 0; j < input[i]; j++) {
                push(&in_s, ++push_num); // 푸시 m번

                push(&output, '+');
                //printf("push_num = %d\n", push_num);
            }
            push(&out_s, in_s.data[in_s.top]); // 팝
            pop(&in_s);

            push(&output, '-');
        }
        else if (i >= 1) {

            if (input[i] < input[i-1] && input[i] == in_s.data[in_s.top]) {
                push(&out_s, in_s.data[in_s.top]); // 팝
                pop(&in_s);
            
                push(&output, '-');
                //printf("push_num = %d\n", push_num);
            }

            else if (input[i] > input[i-1]) {
                int diff = input[i] - push_num;
                for (int j = 0; j < diff; j++) {
                    push(&in_s, ++push_num); // 푸시 m번

                    push(&output, '+');
                    //printf("push_num = %d\n", push_num);
                }
                push(&out_s, in_s.data[in_s.top]); // 팝 1번
                pop(&in_s);

                push(&output, '-');
            }

            else {
                is_possible = 0;
            }
        }
    }
    if (is_possible == 1) {
        for (int i = 0; i <= output.top; i++) {
            printf("%c\n", output.data[i]);
        }
    }
     if (is_possible == 0) {
        printf("NO");
    }

    return 0;
}