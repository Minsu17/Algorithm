import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int[] arr;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, false);
        System.out.println(count);
    }

    static void dfs(int idx, int sum, boolean used) {
        if (idx == N) {
            if (used && sum == S) {
                count++;
            }
            return;
        }

        dfs(idx + 1, sum + arr[idx], true);
        dfs(idx + 1, sum, used);
    }
}
