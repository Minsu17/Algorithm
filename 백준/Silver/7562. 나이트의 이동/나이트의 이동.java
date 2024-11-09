import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int l = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            int moves = bfs(l, startX, startY, endX, endY);
            sb.append(moves).append("\n");
        }

        System.out.print(sb.toString());
    }

    public static int bfs(int l, int startX, int startY, int endX, int endY) {
        if (startX == endX && startY == endY) {
            return 0;
        }

        boolean[][] visited = new boolean[l][l];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {startX, startY, 0});
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            int move = current[2];

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < l && ny >= 0 && ny < l && !visited[nx][ny]) {
                    if (nx == endX && ny == endY) {
                        return move + 1;
                    }

                    q.add(new int[] {nx, ny, move + 1});
                    visited[nx][ny] = true;
                }
            }
        }

        return -1;
    }
}
