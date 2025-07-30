import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//트리의 순회 풀이 코드
public class No2263 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Node> tree = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            tree.add(new Node(i));
        }
        int[] inOrder = new int[n];
        int[] postOrder = new int[n];
        for(int i = 0; i < n; i++) {
            inOrder[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++) {
            postOrder[i] = sc.nextInt();
        }
        restoreTree(tree, inOrder, postOrder, postOrder[n-1], 0, 0, n);
        StringBuilder sb = new StringBuilder();
        preOrder(sb, tree.get(postOrder[n-1]));
        System.out.println(sb);
    }
    private static void preOrder(StringBuilder sb, Node now) {
        sb.append(now.value).append(' ');
        if(now.leftChild != null) {
            preOrder(sb, now.leftChild);
        }
        if(now.rightChild != null) {
            preOrder(sb, now.rightChild);
        }
    }
    private static void restoreTree(List<Node> tree,int[] inOrder, int[] postOrder, int root, int in_start, int post_start, int size) {
        int in_root_idx = 0;
        for(int i = 0; i < size; i++) {
            if(inOrder[in_start+i] == root) {
                in_root_idx = i;
                break;
            }
        }
        int left_size = in_root_idx;
        int right_size = size-in_root_idx-1;
        if(left_size > 0) {
            tree.get(root).setLeftChild(tree.get(postOrder[post_start+left_size-1]));
            restoreTree(tree, inOrder, postOrder, postOrder[post_start+left_size-1], in_start, post_start, left_size);
        }
        if(right_size > 0) {
            tree.get(root).setRightChild(tree.get(postOrder[post_start+left_size+right_size-1]));
            restoreTree(tree, inOrder, postOrder, postOrder[post_start+left_size+right_size-1], in_start+in_root_idx+1, post_start+left_size, right_size);
        }
    }
    private static class Node {
        int value;
        Node leftChild = null;
        Node rightChild = null;
        public Node(int value) {
            this.value = value;
        }
        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }
        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }
    }
}
