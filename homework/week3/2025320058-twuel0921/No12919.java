import java.util.Scanner;

//A와 B 2 풀이 코드
public class No12919 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        System.out.println(compareStrings(s, t) ? 1 : 0);
    }
    private static boolean compareStrings(String s, String t) {
        if(s.length() == t.length()) {
            return s.equals(t);
        }
        boolean a = false;
        boolean b = false;
        if(t.endsWith("A")) {
            a = compareStrings(s, t.substring(0, t.length()-1));
        }
        if(t.startsWith("B")) {
            b = compareStrings(s, new StringBuilder(t.substring(1)).reverse().toString());
        }
        return a || b;
    }
}