import java.util.*;

//암호 만들기 풀이 코드
public class No1759 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int c = sc.nextInt();
        char[] arr = new char[c];
        for(int i = 0; i < c; i++) {
            arr[i] = sc.next().charAt(0);
        }
        Arrays.sort(arr);
        printAllPossiblePassword(arr, new char[l], l, 0, 0);
    }

    private static void printAllPossiblePassword(char[] arr, char[] password, int l, int arrIdx, int passwordIdx) {
        if(passwordIdx == l) {
            int vowel = 0;
            for(int i = 0; i < l; i++) {
                if(isVowel(password[i])) {
                    vowel++;
                }
            }
            if(vowel > 0 && l - vowel >= 2) {
                System.out.println(String.valueOf(password));
            }
            return;
        }
        for(int i = arrIdx; i < arr.length; i++) {
            password[passwordIdx] = arr[i];
            printAllPossiblePassword(arr, password, l, i+1, passwordIdx+1);
        }
    }

    static char[] vowel = {'a','e','i','o','u'};
    private static boolean isVowel(char c) {
        for(int i = 0; i < 5; i++) {
            if(vowel[i] == c) {
                return true;
            }
        }
        return false;
    }
}
