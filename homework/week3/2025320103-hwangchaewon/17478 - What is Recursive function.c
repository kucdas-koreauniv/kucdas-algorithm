#include <stdio.h>

char text[5][130] = {"\"재귀함수가 뭔가요?\"\n",
                     "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n",
                     "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n",
                     "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n",
                     "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n"};

// text[0] => question
// text[1] => text1
// text[2] => text2
// text[3] => text3
// text[4] => answer

void sentence(int index, int target_index, char *s)
{
    if (index == target_index)
    {
        printf(s);
    }
    else
    {
        printf("____");
        sentence(index + 1, target_index, s);
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
    sentence(index, target_index, text[0]); // question
    if (index == 0)
    {
        sentence(index, target_index, text[4]); // answer
        finish(index, target_index);
    }
    else
    {
        sentence(index, target_index, text[1]);
        sentence(index, target_index, text[2]);
        sentence(index, target_index, text[3]);
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