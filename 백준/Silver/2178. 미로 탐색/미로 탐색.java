import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    
    static int N, M;
    static char[][] map;
    static boolean[][] visit;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new char[N+1][M+1];
        visit = new boolean[N+1][M+1];
        
        for (int i = 1; i <= N; i++) {
            map[i] = (" " + br.readLine()).toCharArray();
        }
        System.out.println(bfs(1, 1));
    }
    
    static int bfs(int y, int x) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{y, x});
        visit[y][x] = true;
        
        int[][] distance = new int[N+1][M+1];
        distance[y][x] = 1;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cy = current[0];
            int cx = current[1];
            
            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                
                if (ny > 0 && ny <= N && nx > 0 && nx <= M && map[ny][nx] == '1' && !visit[ny][nx]) {
                    queue.add(new int[]{ny, nx});
                    visit[ny][nx] = true;
                    distance[ny][nx] = distance[cy][cx] + 1;
                    
                    if (ny == N && nx == M) {
                        return distance[ny][nx];
                    }
                }
            }
        }
        
        return -1; 
    }
}