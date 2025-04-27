import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static boolean[] visited;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N+1];
            visited = new boolean[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                if(!visited[i]) {
                    dfs(i);
                    cnt++;
                }
            }
            System.out.println(cnt);
        }

    }

    static void dfs(int current){
        visited[current] = true;
        int next = arr[current];
        if(!visited[next]) {
            dfs(next);
        }
    }
}
