import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Queue<int[]> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                q.add(new int[]{i, Integer.parseInt(st.nextToken())});
            }

            int cnt = 0;
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                boolean high = false;

                for (int[] doc : q) {
                    if (doc[1] > cur[1]) {
                        high = true;
                        break;
                    }
                }

                if (high) {
                    q.add(cur);
                } else {
                    cnt++;
                    if (cur[0] == m) {
                        System.out.println(cnt);
                        break;
                    }
                }
            }
        }
    }
}
