#include <stdio.h>
#include <stdlib.h>

typedef struct person
{
    int index;
    struct person *p_next;
} Person;

Person *head = NULL;
Person *tail = NULL;

int main()
{
    int num_people, step_size;
    scanf("%d %d", &num_people, &step_size);

    for (int i = 0; i < num_people; i++)
    {
        Person *p = (Person *)malloc(sizeof(Person));
        p->p_next = NULL;
        p->index = i + 1;
        if (head == NULL)
        {
            head = p;
            tail = p;
        }
        else
        {
            tail->p_next = p;
            tail = p;
        }
    }
    tail->p_next = head; // 원형 큐??

    Person *p = tail;
    Person *prev = NULL;

    printf("<");

    for (int r = 0; r < step_size; r++)
    {
        prev = p;
        p = p->p_next;
    }
    // 제거
    printf("%d", p->index);
    prev->p_next = p->p_next;

    for (int i = 1; i < num_people; i++)
    {
        for (int r = 0; r < step_size; r++)
        {
            prev = p;
            p = p->p_next;
        }
        // 제거
        printf(", %d", p->index);
        prev->p_next = p->p_next;
    }
    printf(">");

    return 0;
}
