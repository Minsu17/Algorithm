import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int R, C, max = 0;
    static char[][] map;
    static boolean[] alpha = new boolean[26];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        alpha[map[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        System.out.println(max);
    }

    static void dfs(int x, int y, int count) {
        max = Math.max(max, count);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                int index = map[nx][ny] - 'A';
                if (!alpha[index]) {
                    alpha[index] = true;
                    dfs(nx, ny, count + 1);
                    alpha[index] = false;
                }
            }
        }
    }
}
