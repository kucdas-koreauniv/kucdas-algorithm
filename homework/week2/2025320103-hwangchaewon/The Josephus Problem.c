#include <stdio.h>
#include <stdlib.h>

typedef struct person{
    int num;
    struct person* p_next;
}Person;

Person* head = NULL;
Person* tail = NULL;

int main()
{
    int N, K;
    scanf("%d %d", &N, &K);

    for (int i = 0; i < N; i++) {
        Person* p = (Person*)malloc(sizeof(Person));
        p->p_next = NULL;
        p->num = i + 1;
        if (head == NULL) {
            head = p;
            tail = p;
        }
        else {
            tail->p_next = p;
            tail = p;
        }
    }
    tail->p_next = head; // 원형 큐??
    
    Person* p = tail;
    Person* prev = NULL;

    printf("<");
    for (int i = 0; i < N; i++) {
        if(i != 0) printf(", ");
        for (int r = 0; r < K; r++) {
            prev = p;
            p = p->p_next;
        }
        //제거
        printf("%d", p->num);
        prev->p_next = p->p_next;

    }
    printf(">");


    return 0;

}
