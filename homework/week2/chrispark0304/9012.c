#include <stdio.h>
#include <stdlib.h>

typedef struct Stack
{
    char x; //x = '(' or ')'
    struct Stack* Next; //Next가 필요한가..?

} Stack;

Stack* Createnode(char word){
    Stack* Newnode; //구조체 하나하나가 노드 -> Newnode라는 구조체 변수 선언
    Newnode = (Stack*)malloc(sizeof(Stack));

    Newnode->x = word;
    Newnode->Next = NULL;

    return Newnode;
}

int Push(Stack** Head, Stack* node){
    //Stack* current;
    if(node->x == '('){
        node->Next = *Head;  //앞으로 연결
            *Head = node;
            return 0;
        }
    else{
        if(*Head == NULL){
            return 1;
        }
        else{
        *Head = (*Head)->Next;
        return 0;
        }
    }
}



int main(){
    int n;
    scanf("%d",&n);
    for(int i = 0 ; i < n ; i++){
        Stack* Head = NULL;
        char arr[50];
        scanf("%s",arr);

        int flag = 0;
        for(int j = 0 ; arr[j] != '\0' && flag != 1 ; j++){
            Stack* node = Createnode(arr[j]);
            flag = Push(&Head, node);
        }

        if(flag == 1 || Head != NULL){
            printf("NO\n");
        }
        else{
            printf("YES\n");
        }
    }

}