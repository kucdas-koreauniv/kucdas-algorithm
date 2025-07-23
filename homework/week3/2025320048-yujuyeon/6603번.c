#include <stdio.h>
void print(int print_set[]) {
    for (int i = 1; i <= 6; i++) {
        printf("%d ", print_set[i]);
    }
    printf("\n");
}
void lotto(int print_set[], int given_set[], int size, int idx, int flag) {
    if (flag == 1) { // 새로운 조합 단위로 출력
        print(print_set);
    }
    
    if (idx == 0) { // 종료조건
        return;
    }
    
    flag = 0;
    for (int i = 0; i < size; i++) { // 인덱스를 기준으로 뒤에 바꿀 수 있는 번호가 있는지
        if (print_set[idx] < given_set[i] && given_set[i] < print_set[idx + 1]) {
            print_set[idx] = given_set[i];
            flag = 1;
            break;
        }
        else {
            flag = 0;
        }
    }

    if (flag == 1) { // 바뀐 번호를 기준으로 오름차순
        for (; idx < 6; idx++) {
            for (int i = 0; i < size; i++) {
                if (print_set[idx] < given_set[i]) {
                    print_set[idx + 1] = given_set[i];
                    break;
                }
            }
        }
        lotto(print_set, given_set, size, idx, flag);
    }
    else if (flag == 0) { // 바뀌지 않았다면 한 칸 앞으로 가기
        lotto(print_set, given_set, size, idx - 1, flag);
    }
    
}

int main(void) {

    while (1) {
        int size;
        int given_set[12];
        int print_set[] = {-1, 0, 0, 0, 0, 0, 0, 50};
        scanf("%d", &size);
        if (size == 0) {
            break;
        }
        for (int i = 0; i < size; i++) {
            scanf("%d", &given_set[i]);
        }
        for (int i = 0; i < 6; i++) {
            print_set[i + 1] = given_set[i];
        }
        lotto(print_set, given_set, size, 6, 1);
        printf("\n");
    }
        
    return 0;
}