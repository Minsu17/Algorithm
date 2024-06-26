import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static boolean[][] matrix;
	static boolean[] visit;
	static int n, m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		int v = sc.nextInt();
		
		matrix = new boolean[n+1][n+1];
		for(int i=0;i<m;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			matrix[x][y] = true;
			matrix[y][x] = true;
		}
		
		visit = new boolean[n+1];
		dfs(v);
		System.out.println();
		
		visit = new boolean[n+1];
		bfs(v);
	}
	
	static void bfs(int v) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(v);
		visit[v] = true;
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			
			System.out.print(tmp + " ");
			
			for(int i=1;i<=n;i++) {
				if(!matrix[tmp][i] || visit[i]) continue;
				q.offer(i);
				visit[i] = true;
			}
		}
	}
	
	static void dfs(int v) {
		visit[v] = true;
		
		System.out.print(v + " ");
		for(int i=1;i<=n;i++) {
			if(!matrix[v][i] || visit[i]) continue;
			dfs(i);
		}
	}

}