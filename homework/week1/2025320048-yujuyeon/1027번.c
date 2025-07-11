#include <stdio.h>
typedef struct {
    int h;
    int num;
} bldg;

int left(bldg b[], int idx) {
    double incli = 0;
    double min_incli = 1000000001;
    int renew = 0;
    for (int i = 1; idx - i >= 0; i++) {
        incli = ((double)(b[idx].h - b[idx - i].h)) / i; //연산 과정에서의 자료형이 중요함... *명시적 형 변환
        if (incli < min_incli) {
            min_incli = incli;
            renew++;
        }
    }
    return renew;
}
int right(bldg b[], int idx, int max_idx) {
    double incli = 0;
    double max_incli = -1000000001;
    int renew = 0;
    for (int i = 1; idx + i <= max_idx; i++) {
        incli = ((double)(b[idx + i].h - b[idx].h)) / i;
        if (incli > max_incli) {
            max_incli = incli;
            renew++;
        }
    }
    return renew;
}

int main(void) {
    bldg b[50];
    int max_num = 0;
    int n;
    scanf("%d", &n);
   
    for (int i = 0; i < n; i++) {
        scanf("%d", &b[i].h);
    }

    for (int i = 0; i < n; i++) {
        b[i].num = left(b, i) + right(b, i, n - 1);
        if (b[i].num > max_num) {
            max_num = b[i].num;
        }
    }

    printf("%d", max_num);
    
    return 0;
}