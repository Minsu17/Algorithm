import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, H;
    static int[][][] box;
    static int[][][] days;
    static Queue<int[]> queue = new LinkedList<>();
    
    // 상, 하, 좌, 우, 앞, 뒤 6방향을 나타내는 배열
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        box = new int[H][N][M];
        days = new int[H][N][M];
        
        boolean allRipe = true; // 모든 토마토가 익었는지 확인
        boolean allEmpty = true; // 모든 칸이 빈 경우
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    days[i][j][k] = -1;
                    
                    if (box[i][j][k] == 1) {
                        queue.add(new int[]{i, j, k});
                        days[i][j][k] = 0; // 시작점을 0일로 초기화
                        allEmpty = false;
                    } else if (box[i][j][k] == 0) {
                        allRipe = false;
                        allEmpty = false;
                    }
                }
            }
        }
        
        if (allRipe) {
            System.out.println(0);
            return;
        }
        
        if (allEmpty) {
            System.out.println(-1);
            return;
        }
        
        System.out.println(bfs());
    }
    
    public static int bfs() {
        int maxDays = 0;
        
        while (!queue.isEmpty()) {
            int[] tomato = queue.poll();
            int z = tomato[0];
            int y = tomato[1];
            int x = tomato[2];
            
            for (int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if (nz >= 0 && nz < H && ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    if (box[nz][ny][nx] == 0 && days[nz][ny][nx] == -1) {
                        days[nz][ny][nx] = days[z][y][x] + 1;
                        maxDays = Math.max(maxDays, days[nz][ny][nx]);
                        queue.add(new int[]{nz, ny, nx});
                    }
                }
            }
        }
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 0 && days[i][j][k] == -1) {
                        return -1; // 익지 않은 토마토가 남아있는 경우
                    }
                }
            }
        }
        
        return maxDays;
    }
}
