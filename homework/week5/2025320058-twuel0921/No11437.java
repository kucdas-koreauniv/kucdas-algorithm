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
        //이 초기화 없이 더 일반화하는게 가능할까요?
        parents[1] = 1;
        int[] depth = new int[n+1];
        getParentsAndDepth(tree, parents, depth, 1);
        int m = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            sb.append(getLCA(parents, depth, node1, node2)).append('\n');
        }
        System.out.print(sb);
    }
    private static int getLCA(int[] parents, int[] depth, int node1, int node2) {
        while(depth[node1] > depth[node2]) {
            node1 = parents[node1];
        }
        while(depth[node1] < depth[node2]) {
            node2 = parents[node2];
        }
        while(node1 != node2) {
            node1 = parents[node1];
            node2 = parents[node2];
        }
        return node1;
    }
    private static void getParentsAndDepth(List<List<Integer>> tree, int[] parents, int[] depth, int node) {
        for(int child : tree.get(node)) {
            if(parents[child] != 0) {
                continue;
            }
            parents[child] = node;
            depth[child] = depth[node]+1;
            getParentsAndDepth(tree, parents, depth, child);
        }
    }
}
