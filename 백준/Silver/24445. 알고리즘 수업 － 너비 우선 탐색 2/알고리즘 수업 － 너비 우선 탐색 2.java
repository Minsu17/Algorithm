import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R, cnt;
    static int[] visited;
    static List<Integer>[] adjList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        adjList = new LinkedList[N + 1];
        for (int i = 0; i <= N; i++) {
            adjList[i] = new LinkedList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjList[u].add(v);
            adjList[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(adjList[i], Collections.reverseOrder());
        }

        visited = new int[N + 1];
        cnt = 1;

        bfs(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(visited[i]);
        }
    }

    static void bfs(int n) {
        Queue<Integer> q = new ArrayDeque<>();

        visited[n] = cnt++;
        q.add(n);

        while (!q.isEmpty()) {
            int tmp = q.poll();

            for (int next : adjList[tmp]) {
                if (visited[next] == 0) {
                    visited[next] = cnt++;
                    q.add(next);
                }
            }
        }
    }
}