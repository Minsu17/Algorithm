import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
public class Main {
	static int N, M, K, cnt;
	static boolean[][] visited, map;
	static int dy[] = {1, -1, 0, 0};
	static int dx[] = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<>();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new boolean[M][N];
		visited = new boolean[M][N];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int lx = Integer.parseInt(st.nextToken());
			int ly = Integer.parseInt(st.nextToken());
			int rx = Integer.parseInt(st.nextToken());
			int ry = Integer.parseInt(st.nextToken());
			
			for (int j = lx; j < rx; j++) {
				for (int k = ly; k < ry; k++) {
					map[j][k] = true;
				}
			}
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j] && !map[i][j]) {
					cnt = 0;
					dfs(i, j);
					if(cnt != 0) list.add(cnt);
				}
			}	
		}
		Collections.sort(list);
		System.out.println(list.size());
		for (Integer ans : list) {
			System.out.print(ans + " ");
		}
	}
	static void dfs(int y,int x) {
		visited[y][x] = true;
		cnt++;
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(nx < 0 || ny < 0 || ny >= M || nx >= N || map[ny][nx]) continue;
			if(visited[ny][nx]) continue;
			visited[ny][nx] = true;
			dfs(ny, nx);
		}
	}
}