import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//트리 풀이 코드
public class No1068 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> tree = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        int root = -1;
        for(int i = 0; i < n; i++) {
            int parent = sc.nextInt();
            if(parent == -1) {
                root = i;
            } else {
                tree.get(parent).add(i);
            }
        }
        int delete = sc.nextInt();
        if(delete == root) {
            System.out.println(0);
        } else {
            System.out.println(getLeaf(tree, delete, root));
        }
    }
    private static int getLeaf(List<List<Integer>> tree, int delete, int node) {
        if(tree.get(node).contains(delete)) {
            tree.get(node).remove(Integer.valueOf(delete));
        }
        if(tree.get(node).isEmpty()) {
            return 1;
        }
        int leaf = 0;
        for(int child : tree.get(node)) {
            leaf += getLeaf(tree, delete, child);
        }
        return leaf;
    }
}
/* 처음 생각하고 푼 정답 코드(풀어놓고 최적화가 너무 안된 느낌이라 다시 풀어보았습니다.)
public class No1068 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Node> tree = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            tree.add(new Node());
        }
        for(int i = 0; i < n; i++) {
            int parent = sc.nextInt();
            tree.get(i).setParent(tree.get(parent >= 0 ? parent : i));
            tree.get(parent >= 0 ? parent : i).addChild(tree.get(i));
        }
        int delete = sc.nextInt();
        tree.get(delete).parent.children.remove(tree.get(delete));
        tree.get(delete).parent = null;
        int leaf = 0;
        for(int i = 0; i < n; i++) {
            Node node = tree.get(i);
            if(node.parent != null && node.parent.equals(node)) {
                leaf = getLeaf(node);
                break;
            }
        }
        System.out.println(leaf);
    }
    private static int getLeaf(Node node) {
        if(node.children.isEmpty()) {
            return 1;
        }else if(node.children.size() == 1 && node.children.get(0).equals(node)) {
            return 1;
        }
        int leaf = 0;
        for(Node child : node.children) {
            if(child.equals(node)) {
                continue;
            }
            leaf += getLeaf(child);
        }
        return leaf;
    }
    private static class Node {
        Node parent;
        List<Node> children;
        public Node() {
            this.children = new ArrayList<>();
        }
        public void setParent(Node parent) {
            this.parent = parent;
        }
        public void addChild(Node child) {
            this.children.add(child);
        }
    }
}**/