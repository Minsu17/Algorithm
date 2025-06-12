import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            map.put(d, new int[]{r, g});
        }

        int t = 0;
        for (int i = 0; i < l; i++) {
            if (map.containsKey(i)) {
                int[] rg = map.get(i);
                int r = rg[0], g = rg[1];
                int m = t % (r + g);
                if (m < r) t += r - m;
            }
            t++;
        }

        System.out.println(t);
    }
}
