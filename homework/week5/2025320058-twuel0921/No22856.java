import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//트리 순회 풀이 코드
public class No22856 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Node> tree = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            tree.add(new Node(i));
        }
        for(int i = 0; i < n; i++) {
            int currentNode = sc.nextInt();
            int leftChild = sc.nextInt();
            int rightChild = sc.nextInt();
            if(leftChild != -1) {
                tree.get(currentNode).setLeftChild(tree.get(leftChild));
                tree.get(leftChild).setParent(tree.get(currentNode));
            }
            if(rightChild != -1) {
                tree.get(currentNode).setRightChild(tree.get(rightChild));
                tree.get(rightChild).setParent(tree.get(currentNode));
            }
        }
        boolean[] visited = new boolean[n+1];
        System.out.println(pseudoInOrderTraversal(visited, tree.get(1), getEnd(tree.get(1)), 0));
    }
    private static Node getEnd(Node now) {
        Node end = now;
        if(now.rightChild != null) {
            end = getEnd(now.rightChild);
        }
        return end;
    }
    private static int pseudoInOrderTraversal(boolean[] visited, Node now, Node end, int count) {
        if(now.leftChild != null && !visited[now.leftChild.value]) {
            visited[now.leftChild.value] = true;
            return pseudoInOrderTraversal(visited, now.leftChild, end, count+1);
        }else if(now.rightChild != null && !visited[now.rightChild.value]) {
            visited[now.rightChild.value] = true;
            return pseudoInOrderTraversal(visited, now.rightChild, end, count+1);
        }else if(now.value == end.value) {
            return count;
        }else if(now.parent != null) {
            return pseudoInOrderTraversal(visited, now.parent, end, count+1);
        }
        return 0;
    }
    private static class Node {
        int value;
        Node parent = null;
        Node leftChild = null;
        Node rightChild = null;
        public Node(int value) {
            this.value = value;
        }
        public void setParent(Node parent) {
            this.parent = parent;
        }
        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }
        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }
    }
}
