import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Main {

	static int n, cnt;
	static char[][] map;
	static boolean[][] visited;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());

		map = new char[n][];
		visited = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i=0;i<n;i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j] != '1' || visited[i][j]) continue;
				cnt = 0;
				dfs(i, j);
				list.add(cnt);
			}
		}
		
		Collections.sort(list);
		int size = list.size();
		System.out.println(size);
		for (int i = 0; i < size; i++) {
			System.out.println(list.get(i));
		}
		
	}
	
	static void dfs(int y, int x) {
		cnt++;
		visited[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
			if(map[ny][nx] != '1' || visited[ny][nx]) continue;
			
			dfs(ny, nx);
		}
	}
}