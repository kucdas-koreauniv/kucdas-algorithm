#include <stdio.h>
#include <string.h>

int main()
{
    // 입력 : T개의 테스트 데이터
    int T;
    scanf("%d", &T);

    for (int i = 0; i < T; i++) {
        //선언과 동시에 초기화
        int stacksize = 0; // 사이즈 개념만 사용
        char buffer[51] = { 0, };
				scanf("%s", buffer);
        for (int j = 0; j < strlen(buffer); j++) {
            if (stacksize < 0) {
                printf("NO\n");
                break;
            }
            else {
                if (buffer[j] == '(') {
                    stacksize++;
                }
                else if (buffer[j] == ')') {
                    stacksize--;
                }
                else {
                    printf("NO\n");
                    break;
                }
            }

            if (j == strlen(buffer) - 1) {
                if (stacksize == 0) {
                    printf("YES\n");
                }
                else {
                    printf("NO\n");
                }

            }
        }
    }
}
