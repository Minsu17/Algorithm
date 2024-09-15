import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[] cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // A가
            int b = Integer.parseInt(st.nextToken()); // B를 신뢰
            adj[b].add(a);
        }

        cnt = new int[N + 1];
        int max = 0;

        for (int i = 1; i <= N; i++) {
            boolean[] visited = new boolean[N + 1];
            cnt[i] = dfs(i, visited);
            if (cnt[i] > max) {
                max = cnt[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (cnt[i] == max) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb.toString().trim());
    }

    static int dfs(int current, boolean[] visited) {
        int cnt = 1; // 현재 노드도 해킹 가능
        visited[current] = true;

        for (int neighbor : adj[current]) {
            if (!visited[neighbor]) {
                cnt += dfs(neighbor, visited);
            }
        }

        return cnt;
    }
}