import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//보석 도둑 풀이 코드
public class No1202 {
    public static void main(String[] args) throws IOException {
        //Scanner 사용 시 시간초과가 생겨 BufferedReader를 쓰는 쪽으로 구현했습니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Jewel[] jewel = new Jewel[n];
        int[] bag = new int[k];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewel[i] = new Jewel(m,v);
        }
        for(int i = 0; i < k; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(jewel, Comparator.comparingInt(o -> o.weight));
        Arrays.sort(bag);
        long ans = 0;
        MaxHeap heap = new MaxHeap();
        int currentJewel = 0;
        for(int i = 0; i < k; i++) {
            while(currentJewel < n) {
                if(jewel[currentJewel].weight > bag[i]) {
                    break;
                }
                heap.push(jewel[currentJewel].value);
                currentJewel++;
            }
            if(!heap.isEmpty()) {
                ans += heap.pop();
            }
        }
        System.out.println(ans);
    }
    private static class Jewel {
        int weight;
        int value;
        public Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
