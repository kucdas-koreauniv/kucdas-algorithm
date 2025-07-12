#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    // 입력 : 쇠막대기와 레이저의 배치를 나타내는 괄호 표현(100,000)

    char buffer[100001] = { 0, };
    scanf("%s", buffer);

    int len = strlen(buffer);

    // 쇠막대기 조각의 개수를 구하는 로직
    // 스택 안에 있는 값이 필요한 건 아니니까 넣고 빼는 개념만 사용

    // 출력 : 잘려진 쇠막대기 조각의 총 개수
    int n_metalrod = 0;
    int total = 0;

    for (int i = 0; i < len; i++) {
        if (buffer[i] == '(') {
            if (buffer[i + 1] != ')') {
                //push
                n_metalrod++;
            }
            else {
                total += n_metalrod;
				i++; // 레이저를 만났으므로 다음 문자로 이동    
            }
        }
        else if (buffer[i] == ')') {
            //pop
            n_metalrod--;
			total++; // 한 쇠막대기가 끝났으므로 조각이 하나 추가됨  
        }
    }

    printf("%d", total);

}
