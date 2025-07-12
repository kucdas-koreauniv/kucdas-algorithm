#include <stdio.h>
#include <stdlib.h>

typedef struct q {
    int data;
    struct q* p_next;
}Queue;

Queue* front = NULL;
Queue* rear = NULL;

int main() {
    int N; 
    scanf("%d",&N);

    // 초기 상태 : 순서대로 숫자 넣어두기
    for (int i = 1; i <= N; i++) {
		Queue* p = (Queue*)malloc(sizeof(Queue));
        if (p == NULL) {
            printf("메모리 할당 실패");
            return 1; 
		}
        p->data = i;
        p->p_next = NULL;
        if (front == NULL) {
            front = p;
            rear = p;
        }
        else {
            rear->p_next = p;
            rear = p;
		}
    }
    int size = N;

    if(size != 1){
  	// 카드 하나가 남을 때까지 반복 : front 하나 버리고 하나 rear로 옮기기
      while(1) {
          Queue* p = front; 
          front = front->p_next;
          free(p); 
          size--; 
  
          if (size == 1) break;
  
          rear->p_next = front;
          rear = front;
          front = front->p_next;
          rear->p_next = NULL;
      }
    }
  
	printf("%d\n", front->data); 
    free(front);

    return 0;
}
