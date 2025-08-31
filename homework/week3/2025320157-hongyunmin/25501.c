#include <stdio.h>
#include <string.h>

int recursion(const char *str, int left, int right, int *count){
    (*count)++;
	if(left >= right) return 1;
    else if(str[left] != str[right]) return 0;
    else{
    	return recursion(str, left + 1, right - 1, count);
	}
}

int isPalindrome(const char *str, int *count){
    return recursion(str, 0, strlen(str) - 1, count);
}

int main(){
	int testcase;
	scanf("%d", &testcase);
	
	for(int t = 0; t < testcase; t++){
		char str[1000];
		int count = 0;
		scanf("%s", str);
		int result = isPalindrome(str, &count);
		printf("%d %d\n", result, count);
	}
}