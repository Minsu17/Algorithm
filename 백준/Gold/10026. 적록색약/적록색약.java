import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static char[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        // 적록색약이 아닌 경우
        visited = new boolean[N][N];
        int count1 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, arr[i][j]);
                    count1++;
                }
            }
        }

        // 적록색약인 경우 (R과 G를 동일하게 처리)
        visited = new boolean[N][N];
        int count2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfsColorBlind(i, j, arr[i][j]);
                    count2++;
                }
            }
        }

        System.out.println(count1 + " " + count2);


    }
    static void dfs(int x, int y, char color) {
        visited[x][y] = true;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && arr[nx][ny] == color) {
                dfs(nx, ny, color);
            }
        }
    }

    static void dfsColorBlind(int x, int y, char color) {
        visited[x][y] = true;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                if ((color == 'R' || color == 'G') && (arr[nx][ny] == 'R' || arr[nx][ny] == 'G')) {
                    dfsColorBlind(nx, ny, color);
                } else if (color == 'B' && arr[nx][ny] == 'B') {
                    dfsColorBlind(nx, ny, color);
                }
            }
        }
    }
}
