import java.util.Scanner;
import java.util.Stack;

//쇠막대기 풀이코드
public class No1099 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '(') {
                stack.push(0);
            }else {
                if(stack.peek() == 0) {
                    stack.pop();
                    stack.push(1);
                }else {
                    int laser = 0;
                    while(stack.peek() > 0) {
                        laser += stack.pop();
                    }
                    ans += laser + 1;
                    stack.pop();
                    stack.push(laser);
                }
            }
        }
        System.out.println(ans);
    }
}