#include <stdio.h>
#include <stdlib.h>

typedef struct stack {
    int data;
   int tower_index; 
    struct stack* p_down;
}Stack;

Stack* top = NULL;

int main() {
    int N;
    scanf("%d", &N);

    int temp = 0;

    
    int isSuccess = 0; // 송신 성공 여부


    for (int i = 0; i < N; i++) {

        scanf("%d", &temp);

      isSuccess = 0; // 송신 성공 여부 초기화

        // 수신받을 후보 스택으로 복사 + 불필요한(지금 들어온 값보다 작은) 탑 제거 + 송신 시도
        Stack* p_recept = (Stack*)malloc(sizeof(Stack));
        if (p_recept == NULL) {
            printf("메모리 할당 실패");
            return 1;
        }
        p_recept->data = temp;
      p_recept->tower_index = i + 1; 
        p_recept->p_down = NULL;

        if (top == NULL) {
            top = p_recept;
            printf("0 ");
        }
        else {
                    
         Stack* p = top;
         Stack* p_up = NULL; 
               while (p != NULL) {
                   if(p->data < p_recept->data) {
                       Stack* p_temp = p;
                       if (p_up != NULL) {
                           p_up->p_down = p->p_down;
                       }
                       else {
                           top = p->p_down;
                       }
                       p = p->p_down;
                       free(p_temp);
                   }
                   else {
                       if(isSuccess == 0) {
                           printf("%d ", p->tower_index);
                           isSuccess = 1;
                  }
                       p_up = p;
                       p = p->p_down;
                   }
                   
               }
               p_recept->p_down = top;
               top = p_recept;


               if (isSuccess == 0) {
                   printf("0 ");
               }
            
            
        }

       
    }

  
    while (top != NULL) {
        Stack* p = top;
        top = top->p_down;
        free(p);
    }


    return 0;
}
