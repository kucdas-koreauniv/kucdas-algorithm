import java.util.Scanner;

//완전 이진 트리 풀이 코드
public class No9934 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int[] tree = new int[(1<<k)];
        int[] note = new int[(1<<k)-1];
        for(int i = 0; i < note.length; i++) {
            note[i] = sc.nextInt();
        }
        getTree(tree, note, 1, 0);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < k; i++) {
            for(int j = (1<<i); j < (1<<(i+1)); j++) {
                sb.append(tree[j]).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    private static int getTree(int[] tree, int[] note, int node, int noteIdx) {
        if(node >= tree.length) {
            return 0;
        }
        int left = getTree(tree, note, node*2, noteIdx);
        tree[node] = note[noteIdx + left];
        int right = getTree(tree, note, node*2+1, noteIdx+left+1);
        return left + right + 1;
    }
}
