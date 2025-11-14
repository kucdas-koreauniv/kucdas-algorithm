import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//괄호 풀이코드
public class No9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++) {
            Stack<Character> stack = new Stack<>();
            String line = br.readLine();
            for(int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                if(c == '(') {
                    stack.push(c);
                }else {
                    if(stack.isEmpty()) {
                        sb.append("NO").append("\n");
                        break;
                    }else {
                        stack.pop();
                    }
                }
                if(j == line.length()-1 && stack.isEmpty()) {
                    sb.append("YES").append("\n");
                }else if(j == line.length()-1 && !stack.isEmpty()) {
                    sb.append("NO").append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}