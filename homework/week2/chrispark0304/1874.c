#include <stdio.h>
#include <stdlib.h>

typedef struct Stack{
    int x;
    struct Stack* Nextnode;
}Stack;

Stack* Createnode(int i){
    Stack* Newnode;
    Newnode = (Stack*)malloc(sizeof(Stack));
    Newnode->x = i;
    Newnode->Nextnode = NULL;
    return Newnode;
}

void Push(Stack** Head, int i){
    if(*Head == NULL){
        *Head = Createnode(i);
    }
    else{
        Stack* currentnode = *Head;
        *Head = Createnode(i);
        (*Head)->Nextnode = currentnode;
    }
}

void Pop(Stack** Head){
    Stack* curr = (*Head)->Nextnode;
    (*Head) = curr;
}

int Top(Stack* Head){
    if(Head == NULL){
        return 0;
    }
    else{
        return Head->x;
    }
}

int Isempty(Stack* Head){
    if(Head == NULL){
        return 1;
    }
    else{
        return 0;
    }
}



int main(){
    int n;
    int* numarr;

    scanf("%d",&n);
    
    numarr = (int*)malloc(sizeof(int)*n);
    //numarr[n];

    //Stack생성
    Stack* Head = NULL;

    char sign[200002] = {0,};
    for(int i = 0 ; i < n ; i++){
        scanf("%d",&numarr[i]);
    }
    int order = 0; //0 <= order <= n-1
    int curr = 1;

    for(int i = 0 ; i < n ; i++){
        int target = numarr[i];
        while(curr <= target){
            Push(&Head, curr++);
            sign[order++] = '+';
        }
        if(Top(Head) == target){
            Pop(&Head);
            sign[order++] = '-';
        }
        else{
            printf("NO");
            return 0;
        }
    } 

    for(int i = 0 ; sign[i] != '\0' ; i++){
        printf("%c\n",sign[i]);
    }
}