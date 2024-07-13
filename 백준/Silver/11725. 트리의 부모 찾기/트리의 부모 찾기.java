import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static List<List<Integer>> adj;
	static int[] parent;
	static boolean[] visit;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        adj = new ArrayList<>(N+1);
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < N-1; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	adj.get(a).add(b);
        	adj.get(b).add(a);
		}
        
        parent = new int[N+1];
        visit = new boolean[N+1];
        
        dfs(1);
        
        for (int i = 2; i <= N; i++) {
			System.out.println(parent[i]);
		}
    }
    
    static void dfs(int idx) {
    	visit[idx] = true;
    	
    	for (int node : adj.get(idx)) {
			if(visit[node]) continue;
			parent[node] = idx;
			dfs(node);
		}
    }
}