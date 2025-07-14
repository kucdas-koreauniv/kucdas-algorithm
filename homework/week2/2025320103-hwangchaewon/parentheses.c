#include <stdio.h>
#include <string.h>

int main()
{
    // 입력 : T개의 테스트 데이터
    int num_testcase;
    scanf("%d", &num_testcase);

    for (int i = 0; i < num_testcase; i++)
    {
        // 선언과 동시에 초기화
        int stacksize = 0; // 사이즈 개념만 사용
        char buffer[51] = {
            0,
        };
        scanf("%s", buffer);

        int buffer_len = strlen(buffer);
        for (int j = 0; j < buffer_len; j++)
        {
            if (buffer[j] == '(')
            {
                stacksize++;
            }
            else if (buffer[j] == ')')
            {
                stacksize--;
            }
            else
            {
                printf("NO\n");
                break;
            }

            if (stacksize < 0)
            {
                printf("NO\n");
                break;
            }
        }
        if (stacksize == 0)
        {
            printf("YES\n");
        }
        else if (stacksize > 0)
        {
            printf("NO\n");
        }
    }
    return 0;
}
