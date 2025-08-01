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
                setPrefixNode(tree, number, "", 0);
            }
            int leaf = getLeaf(tree);
            sb.append(leaf == n ? "YES" : "NO").append('\n');
        }
        System.out.println(sb);
    }
    //dfs를 통해 접두어 노드를 찾는 식으로 구현했는데 시간 차이는 크지 않은 듯 합니다.
    //지금 생각해보니 사실상 처음 코드와 다를 바 없는 듯 하네요...
    private static void setPrefixNode(Node now, String number, String curPref, int len) {
        if(len == number.length()) {
            return;
        }
        boolean hasChanged = false;
        for(Node child : now.children) {
            if(child.value.equals(curPref+number.charAt(len))) {
                setPrefixNode(child, number, curPref+number.charAt(len), len+1);
                hasChanged = true;
                break;
            }
        }
        if(!hasChanged) {
            Node child = new Node(curPref+number.charAt(len));
            now.addChild(child);
            setPrefixNode(child, number, curPref+number.charAt(len), len+1);
        }
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
