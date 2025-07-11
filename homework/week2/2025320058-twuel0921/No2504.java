import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//괄호의 값 풀이 코드
public class No2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < line.length(); i++) {
            if(line.charAt(i) == '(') {
                stack.push(2);
            } else if(line.charAt(i) == ')') {
                if(stack.isEmpty()) break;
                if(stack.peek() == 2) {
                    stack.pop();
                    stack.push(-2);
                }else if(stack.peek() < 0) {
                    int x = 0;
                    do {
                        x += stack.pop();
                    }while(!stack.isEmpty() && stack.peek() < 0);
                    if(!stack.isEmpty() && stack.peek() == 2) {
                        stack.pop();
                        stack.push(x * 2);
                    }else {
                        break;
                    }
                }
            } else if(line.charAt(i) == '[') {
                stack.push(3);
            } else if(line.charAt(i) == ']') {
                if(stack.isEmpty()) break;
                if(stack.peek() == 3) {
                    stack.pop();
                    stack.push(-3);
                }else if(stack.peek() < 0) {
                    int x = 0;
                    do {
                        x += stack.pop();
                    }while(!stack.isEmpty() && stack.peek() < 0);
                    if(!stack.isEmpty() && stack.peek() == 3) {
                        stack.pop();
                        stack.push(x * 3);
                    }else {
                        break;
                    }
                }
            }
        }
        int ans = 0;
        while(!stack.isEmpty()) {
            if(stack.peek() > 0) {
                System.out.println(0);
                return;
            }
            ans -= stack.pop();
        }
        System.out.println(ans);
    }
}