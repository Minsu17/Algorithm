import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M;
    static char[][] campus;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] size = br.readLine().split(" ");
        N = Integer.parseInt(size[0]);
        M = Integer.parseInt(size[1]);

        campus = new char[N][M];
        visited = new boolean[N][M];

        int startX = 0, startY = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                campus[i][j] = line.charAt(j);
                if (campus[i][j] == 'I') {
                    startX = i;
                    startY = j;
                }
            }
        }

        dfs(startX, startY);

        System.out.println(count == 0 ? "TT" : count);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        if (campus[x][y] == 'P') {
            count++;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (!visited[nx][ny] && campus[nx][ny] != 'X') {
                    dfs(nx, ny);
                }
            }
        }
    }
}
