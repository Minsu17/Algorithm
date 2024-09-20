import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
    static int r1, c1, r2, c2, N;
    static int[] dy = {-2, -2, 0, 0, 2, 2};
    static int[] dx = {-1, 1, -2, 2, -1, 1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());
        System.out.println(bfs(r1, c1));
    }
    static int bfs(int y, int x) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {y, x, 0});
        visited[y][x] = true; // 큐에 넣은 후 방문 처리
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int curY = current[0];
            int curX = current[1];
            int move = current[2];
            if (curY == r2 && curX == c2) return move; // 목표 지점 도착
            for (int i = 0; i < 6; i++) {
                int ny = curY + dy[i];
                int nx = curX + dx[i];
                // 범위 체크
                if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                // 방문 여부 체크
                if (!visited[ny][nx]) {
                    visited[ny][nx] = true; // 방문 처리
                    q.offer(new int[] {ny, nx, move + 1});
                }
            }
        }
        return -1; // 목표 지점에 도착할 수 없는 경우
    }
}