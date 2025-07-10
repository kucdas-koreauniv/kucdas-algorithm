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

    int temp = 0;
	int size = 0;

    while (1) {

        scanf("%d", &temp);

 
        if (temp == 0) { // 패킷 하나 처리
            Queue* p = front;
			front = front->p_next;
            free(p);
            size--;
        }
        else if (temp == -1) { // 입력의 끝
            break;
        }
        else {

            if (size >= N) { // 큐가 가득 찼을 때
            }
            else {
                Queue* p_buffer = (Queue*)malloc(sizeof(Queue));
                p_buffer->p_next = NULL;

                p_buffer->data = temp;
                size++;
                if (front == NULL) { // 비어있을 때
                    front = p_buffer;
                    rear = p_buffer;
                }
                else {
                    rear->p_next = p_buffer;
                    rear = p_buffer;
                }
            }

            
        }

    }

    for (int i = 0; i < size; i++) {
        Queue* p = front;
		printf("%d ", p->data);
        front = front->p_next; // front를 다음 노드로 이동
        free(p); // 현재 노드 메모리 해제
    }
	



    return 0;
}
