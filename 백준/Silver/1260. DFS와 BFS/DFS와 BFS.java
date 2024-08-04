import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, V;
	static boolean[][] matrix;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		matrix = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			matrix[u][v] = true;
			matrix[v][u] = true;
		}
		
		dfs(V);
		System.out.println();
		
		visited = new boolean[N+1];
		bfs(V);
	}
	
	static void dfs(int v) {
		visited[v] = true;
		
		System.out.print(v + " ");
		for (int i = 1; i <= N; i++) {
			if(!matrix[v][i] || visited[i]) continue;
			dfs(i);
		}
	}
	
	static void bfs(int v) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(v);
		visited[v] = true;
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			
			System.out.print(tmp + " ");
			
			for (int i = 1; i <= N; i++) {
				if(!matrix[tmp][i] || visited[i]) continue;
				q.offer(i);
				visited[i] = true;
			}
		}
	}
}