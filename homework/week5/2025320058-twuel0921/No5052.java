import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//전화번호 목록 풀이 코드
public class No5052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while(t-- > 0) {
            int n = sc.nextInt();
            Node tree = new Node("");
            for(int i = 0; i < n; i++) {
                String number = sc.next();
                Node current = tree;
                for(int j = 0; j < number.length(); j++) {
                    boolean hasChanged = false;
                    for(Node child : current.children) {
                        if(child.value.equals(number.substring(0, j+1))) {
                            current = child;
                            hasChanged = true;
                            break;
                        }
                    }
                    if(!hasChanged) {
                        Node child = new Node(number.substring(0, j+1));
                        current.addChild(child);
                        current = child;
                    }
                }
            }
            int leaf = getLeaf(tree);
            sb.append(leaf == n ? "YES" : "NO").append('\n');
        }
        System.out.println(sb);
    }
    private static int getLeaf(Node node) {
        if(node.children.isEmpty()) {
            return 1;
        }
        int leaf = 0;
        for(Node child : node.children) {
            leaf += getLeaf(child);
        }
        return leaf;
    }
    private static class Node {
        String value;
        List<Node> children;
        public Node(String value) {
            this.value = value;
            children = new ArrayList<>();
        }
        public void addChild(Node child) {
            children.add(child);
        }
    }
}
