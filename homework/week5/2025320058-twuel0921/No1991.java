import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//트리 순회 풀이 코드
public class No1991 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Node<Character>> tree = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            tree.add(new Node<>((char)('A'+i)));
        }
        for(int i = 0; i < n; i++) {
            char node = sc.next().charAt(0);
            char leftChild = sc.next().charAt(0);
            char rightChild = sc.next().charAt(0);
            if(leftChild != '.') {
                tree.get(node-'A').setLeftChild(tree.get(leftChild-'A'));
            }
            if(rightChild != '.') {
                tree.get(node-'A').setRightChild(tree.get(rightChild-'A'));
            }
        }
        StringBuilder sb = new StringBuilder();
        preorderTraversal(sb, tree.get(0));
        sb.append('\n');
        inorderTraversal(sb, tree.get(0));
        sb.append('\n');
        postorderTraversal(sb, tree.get(0));
        sb.append('\n');
        System.out.println(sb);
    }
    public static void preorderTraversal(StringBuilder sb, Node<Character> now) {
        sb.append(now.value);
        if(now.leftChild != null) {
            preorderTraversal(sb, now.leftChild);
        }
        if(now.rightChild != null) {
            preorderTraversal(sb, now.rightChild);
        }
    }
    public static void inorderTraversal(StringBuilder sb, Node<Character> now) {
        if(now.leftChild != null) {
            inorderTraversal(sb, now.leftChild);
        }
        sb.append(now.value);
        if(now.rightChild != null) {
            inorderTraversal(sb, now.rightChild);
        }
    }
    public static void postorderTraversal(StringBuilder sb, Node<Character> now) {
        if(now.leftChild != null) {
            postorderTraversal(sb, now.leftChild);
        }
        if(now.rightChild != null) {
            postorderTraversal(sb, now.rightChild);
        }
        sb.append(now.value);
    }
    private static class Node<T> {
        T value;
        Node<T> leftChild = null;
        Node<T> rightChild = null;
        public Node(T value) {
            this.value = value;
        }
        public void setLeftChild(Node<T> leftChild) {
            this.leftChild = leftChild;
        }
        public void setRightChild(Node<T> rightChild) {
            this.rightChild = rightChild;
        }
    }
}