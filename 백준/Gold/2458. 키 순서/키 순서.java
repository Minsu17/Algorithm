import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static ArrayList<Integer>[] graph, reverseGraph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        reverseGraph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            reverseGraph[b].add(a);
        }
        int result = 0;

        for (int i = 1; i <= N; i++){
            visited = new boolean[N + 1];
            int taller = dfs(i, graph);

            visited = new boolean[N + 1];
            int shoter = dfs(i, reverseGraph);

            if(taller + shoter == N - 1) result++;
        }

        System.out.println(result);

    }

    static int dfs(int u, ArrayList<Integer>[] g){
        visited[u] = true;
        int cnt = 0;
        for(int v : g[u]){
            if(!visited[v]){
                cnt += 1 + dfs(v, g);
            }
        }
        return cnt;
    }
}
