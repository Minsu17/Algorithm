import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
	static int h, w, cnt;
	static int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1};
	static int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
	static boolean[][] visit;
	static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        while(true) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	cnt = 0;
        	w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
        	if(h == 0 && w == 0) break;
        	map = new int[h][w];
        	
        	for(int i=0;i<h;i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j=0;j<w;j++) {
        			map[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	visit = new boolean[h][w];
        	for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(!visit[i][j] && map[i][j] == 1) {
						cnt++;
						dfs(i, j);
					}
				}
			}
        	System.out.println(cnt);
        }
    }
    
    static void dfs(int y, int x) {
    	visit[y][x] = true;
    	
    	for (int i = 0; i < 8; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny < 0 || nx < 0 || ny >= h || nx >= w) continue;
			if(map[ny][nx] == 0 || visit[ny][nx]) continue;
			visit[ny][nx] = true;
			dfs(ny, nx);
		}
    }
}