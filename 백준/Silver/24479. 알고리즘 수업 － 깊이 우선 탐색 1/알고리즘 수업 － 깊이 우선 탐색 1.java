import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    
    static int N, M, R;
    static List<Integer>[] adjList;
    static boolean[] visited;
    static int[] order;
    static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        adjList = new ArrayList[N+1];
        visited = new boolean[N+1];
        order = new int[N+1];
        cnt = 1;

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            adjList[u].add(v);
            adjList[v].add(u);
        }
        for (int i = 1; i <= N; i++) {
			Collections.sort(adjList[i]);
		}
        dfs(R);
        
        for (int i = 1; i <= N; i++) {
            System.out.println(order[i]);
        }
    }
    
    static void dfs(int v) {
        visited[v] = true;
        order[v] = cnt++;
        
        for (int next : adjList[v]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}