#include <stdio.h>
#define Max 100001

int main(){
    char bracket[Max] = {0,};
    int stack[Max] = {0,};
    scanf("%s",bracket);

    
    int count = 0;
    int flag = 0; //1이면 여는 괄호, 0이면 닫는 괄호

    int top = -1;

    for(int i = 0 ; bracket[i] != '\0' ; i++){
        if(bracket[i] == '('){
            top++;
            stack[top] = top + 1;
            flag = 1;
        }
        else if(bracket[i] == ')' && flag == 1){
            // 처음으로 닫히는 괄호
            
            count += stack[--top];
            flag = 0;
        }
        else if(bracket[i] == ')' && flag == 0){
            // 선분이 끝나는 점
            count++;
            top--;
        }
    }
    
    printf("%d",count);
}