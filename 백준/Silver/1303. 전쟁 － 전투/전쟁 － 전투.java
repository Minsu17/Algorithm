import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	static int N, M, cnt;
	static int w, b;
	static char[][] matrix;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        matrix = new char[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
			char[] arr = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				matrix[i][j] = arr[j];
			}
		}
        
        for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visited[i][j]) {
					cnt = 0;
					dfs(i, j, matrix[i][j]);
					if(matrix[i][j] == 'W') w += cnt * cnt;
					else b += cnt * cnt;
				}
			}
		}
        
        System.out.println(w + " " + b);
        
    }
    
    static void dfs(int x, int y, char c) {
    	visited[x][y] = true;
    	cnt++;
    	
    	for(int i=0;i<4;i++) {
    		int nx = dx[i] + x;
    		int ny = dy[i] + y;
    		
    		if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || matrix[nx][ny] != c) continue;
    		dfs(nx, ny, c);
    	}
    }
}