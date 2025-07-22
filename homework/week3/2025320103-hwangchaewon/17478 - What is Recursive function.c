#include <stdio.h>

char *str_question = "\"재귀함수가 뭔가요?\"\n";
char *str_explain1 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
char *str_explain2 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
char *str_explain3 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
char *str_answer = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";

// text[0] => question
// text[1] => text1
// text[2] => text2
// text[3] => text3
// text[4] => answer

void sentence(int index, int target_index, char *str)
{
    if (index == target_index)
    {
        printf(str);
    }
    else
    {
        printf("____");
        sentence(index + 1, target_index, str);
    }
}

void finish(int index, int target_index)
{
    if (target_index < 0)
    {
        return;
    }
    if (index == target_index)
    {
        printf("라고 답변하였지.\n");
        finish(0, target_index - 1);
    }
    else
    {
        printf("____");
        finish(index + 1, target_index);
    }
}

void recursion(int index, int target_index)
{
    sentence(index, target_index, str_question); // question
    if (index == 0)
    {
        sentence(index, target_index, str_answer); // answer
        finish(index, target_index);
    }
    else
    {
        sentence(index, target_index, str_explain1);
        sentence(index, target_index, str_explain2);
        sentence(index, target_index, str_explain3);
        recursion(index - 1, target_index);
    }
}

int main()
{

    int num_recursion;
    scanf("%d", &num_recursion);

    printf("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");

    recursion(num_recursion, num_recursion);

    return 0;
}