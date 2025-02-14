import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int N, K, time;
    static int[] visited = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N, K));
    }
    public static int bfs(int N, int K) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(N);
        visited[N] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if(cur == K){
                return visited[cur]-1;
            }

            int[] nextPositions = {cur -1, cur + 1, cur * 2};
            for(int next : nextPositions){
                if(next >= 0 && next <= 100000 && visited[next] == 0) {
                    visited[next] = visited[cur] + 1;
                    q.add(next);
                }
            }
        }
        return -1;
    }
}
