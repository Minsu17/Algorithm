import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	static int R, C, s, w, v, k;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static char[][] matrix;
	static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        matrix = new char[R][C];
        visited = new boolean[R][C];
        
        for (int i = 0; i < R; i++) {
			matrix[i] = br.readLine().toCharArray();
		}
        
        for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {

				if(matrix[i][j] != '#' && !visited[i][j]) {
					v = 0;
					k = 0;
					dfs(i, j);
					
	                if (k > v) {
	                    s += k;
	                } else {
	                    w += v;
	                }
				}

			}
		}
        
        System.out.println(s + " " + w);
    }
    
    static void dfs(int y, int x) {
    	visited[y][x] = true;
    	if(matrix[y][x] == 'v') v++;
    	if(matrix[y][x] == 'k') k++;
    	
    	for (int i = 0; i < 4; i++) {
			int ny = dy[i] + y;
			int nx = dx[i] + x;
			
			if(ny < 0 || ny >= R || nx < 0 || nx >= C || visited[ny][nx] || matrix[ny][nx] == '#') continue;
			visited[ny][nx] = true;
			dfs(ny, nx);
		}
    	
    }
    
}