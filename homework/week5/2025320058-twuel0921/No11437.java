import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

//LCA 풀이 코드
public class No11437 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> tree = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        for(int i = 0; i < n-1; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            tree.get(node1).add(node2);
            tree.get(node2).add(node1);
        }
        int[] parents = new int[n+1];
        getParents(tree, parents);
        int[] depth = new int[n+1];
        getDepth(tree, depth);
        int m = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            while(depth[node1] > depth[node2]) {
                node1 = parents[node1];
            }
            while(depth[node1] < depth[node2]) {
                node2 = parents[node2];
            }
            sb.append(getLCA(parents, node1, node2)).append('\n');
        }
        System.out.print(sb);
    }
    private static int getLCA(int[] parents, int node1, int node2) {
        if(node1 == node2) {
            return node1;
        }
        return getLCA(parents, parents[node1], parents[node2]);
    }
    private static void getParents(List<List<Integer>> tree, int[] parents) {
        parents[1] = 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            for(int child : tree.get(node)) {
                if(parents[child] != 0) {
                    continue;
                }
                parents[child] = node;
                stack.push(child);
            }
        }
    }
    private static void getDepth(List<List<Integer>> tree, int[] depth) {
        depth[1] = 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            for(int child : tree.get(node)) {
                if(depth[child] != 0) {
                    continue;
                }
                depth[child] = depth[node]+1;
                stack.push(child);
            }
        }
    }
}
