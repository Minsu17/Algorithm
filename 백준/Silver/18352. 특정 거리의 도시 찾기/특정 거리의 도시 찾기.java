import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K, X;
    static List<Integer>[] graph;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new List[N + 1];
        distance = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }

        Arrays.fill(distance, -1);

        bfs(X);

        boolean found = false;
        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) {
                System.out.println(i);
                found = true;
            }
        }

        if (!found) System.out.println(-1);
    }

    static void bfs(int x) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(x);
        distance[x] = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : graph[u]) {
                if (distance[v] == -1) {
                    distance[v] = distance[u] + 1;
                    q.add(v);
                }
            }
        }
    }
}
