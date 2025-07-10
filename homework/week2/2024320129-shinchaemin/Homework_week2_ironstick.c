#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void){
	int stick_num = 0;
	int stick = 0;
	char seq[100000];
	fgets(seq, sizeof(seq), stdin);
	seq[strcspn(seq, "\n")] = '\0';

	for (int i = 0;i < strlen(seq) - 1;i++) {
		if (seq[i] == '(') {
			if (seq[i + 1] == '(') {
				stick_num++;
				stick++;
			}
			else if (seq[i + 1] == ')') {
				stick_num = stick_num + stick;
			}
			else break;
		}
		else {
			if (seq[i + 1] == ')') {
				stick--;
			}
		}
	}
	printf("%d", stick_num);
	return 0;
}