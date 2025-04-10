import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());

        int dasom = Integer.parseInt(br.readLine());
        for (int i = 1; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int cnt = 0;

        while(!pq.isEmpty() && pq.peek() >= dasom) {
            int maxVote = pq.poll();
            maxVote--;
            dasom++;
            cnt++;
            pq.add(maxVote);
        }
        System.out.println(cnt);
    }
}
