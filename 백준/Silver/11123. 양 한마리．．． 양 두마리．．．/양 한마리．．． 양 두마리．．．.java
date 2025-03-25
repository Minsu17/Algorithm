import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int H, W, cnt;
    static boolean[][] visited;
    static char[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            map = new char[H][W];
            visited = new boolean[H][W];

            for (int i = 0; i < H; i++) {
                map[i] = br.readLine().toCharArray();
            }

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (!visited[i][j] && map[i][j] == '#') {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
            if (!visited[nx][ny] && map[nx][ny] == '#') {
                dfs(nx, ny);
            }
        }
    }
}
