import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	static int N, cnt, max, ans;
	static int[][] map;
	static boolean[][] visit;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		ans = 1;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}
		for (int i = 1; i <= max; i++) {
			cnt = 0;
			visit = new boolean[N][N];
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if(map[j][k] > i && !visit[j][k]) {
						dfs(j, k, i);
						cnt++;
					}
				}
			}
			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
	}
	
	static void dfs(int y, int x, int h) {
		visit[y][x] = true;
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if(ny < 0 || nx < 0 || ny >= N || nx >= N || h >= map[ny][nx]) continue;
			if(visit[ny][nx]) continue;
			visit[ny][nx] = true;
			dfs(ny, nx, h);
		}
	}
}