import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

//트리의 부모 찾기 풀이 코드
public class No11725 {
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
        Arrays.fill(parents, 0);
        getParents(tree, parents);
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= n; i++) {
            sb.append(parents[i]).append('\n');
        }
        System.out.println(sb);
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
}