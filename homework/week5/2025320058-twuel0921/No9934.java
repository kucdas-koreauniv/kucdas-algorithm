import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//완전 이진 트리 풀이 코드
public class No9934 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int[] note = new int[(1<<k)-1];
        for(int i = 0; i < note.length; i++) {
            note[i] = sc.nextInt();
        }
        List<List<Integer>> treeByLevel = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            treeByLevel.add(new ArrayList<>());
        }
        getTree(treeByLevel, note, 0, 0, note.length);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < k; i++) {
            for(int j = 0; j < treeByLevel.get(i).size(); j++) {
                sb.append(treeByLevel.get(i).get(j)).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    private static void getTree(List<List<Integer>> treeByLevel, int[] note, int depth, int start, int size) {
        if(depth == treeByLevel.size()) {
            return;
        }
        treeByLevel.get(depth).add(note[start+size/2]);
        getTree(treeByLevel, note, depth+1, start, size/2);
        getTree(treeByLevel, note, depth+1, start+size/2+1, size/2);
    }
}