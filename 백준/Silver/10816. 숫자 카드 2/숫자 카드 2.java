import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        Map<Integer, Integer> cardCount = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            cardCount.put(num, cardCount.getOrDefault(num, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(cardCount.getOrDefault(target, 0)).append(' ');
        }

        System.out.println(sb);
    }
}
