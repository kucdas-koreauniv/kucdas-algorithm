import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//후위 표기식 풀이 코드
public class No1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String exp = br.readLine();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if(isAlphabet(c)) {
                sb.append(c);
            }else {
                if(stack.isEmpty()) {
                    stack.push(c);
                }else {
                    if(c == '('){
                        stack.push(c);
                    }else if(c == ')') {
                        while(stack.peek() != '(') {
                            sb.append(stack.pop());
                        }
                        stack.pop();
                    }else {
                        while(!stack.isEmpty() && getComputeOrder(stack.peek()) >= getComputeOrder(c)) {
                            sb.append(stack.pop());
                        }
                        stack.push(c);
                    }
                }
            }
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
    private static boolean isAlphabet(char c) {
        return c >= 'A' && c <= 'Z';
    }
    private static int getComputeOrder(char c) {
        switch(c) {
            case '+':
            case '-':
                return 0;
            case '*':
            case '/':
                return 1;
        }
        return -1;
    }
}