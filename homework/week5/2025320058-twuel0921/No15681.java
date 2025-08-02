import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//트리와 쿼리 풀이 코드
public class No15681 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int q = sc.nextInt();
        List<List<Integer>> tree = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        for(int i = 0; i < n-1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        int[] subtree = new int[n+1];
        boolean[] visited = new boolean[n+1];
        getNodeInSubtree(tree, subtree, visited, r);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++) {
            sb.append(subtree[sc.nextInt()]).append('\n');
        }
        System.out.print(sb);
    }
    private static void getNodeInSubtree(List<List<Integer>> tree, int[] subtree, boolean[] visited, int now) {
        visited[now] = true;
        subtree[now] = 1;
        for(int child : tree.get(now)) {
            if(!visited[child]) {
                getNodeInSubtree(tree, subtree, visited, child);
                subtree[now] += subtree[child];
            }
        }
    }
}
