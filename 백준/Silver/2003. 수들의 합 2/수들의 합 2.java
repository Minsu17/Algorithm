import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

        int start = 0, end = 0, sum = 0, count = 0;
        while (true) {
            if (sum >= m) sum -= a[start++];
            else if (end == n) break;
            else sum += a[end++];
            if (sum == m) count++;
        }
        System.out.print(count);
    }
}
