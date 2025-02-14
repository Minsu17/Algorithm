import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();
        int unripeCount = 0; // 익지 않은 토마토 개수
        int days = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    queue.add(new int[]{i, j, 0});  // 익은 토마토를 큐에 추가
                } else if (map[i][j] == 0) {
                    unripeCount++;  // 익지 않은 토마토 개수 세기
                }
            }
        }

        days = bfs(queue, unripeCount);

        System.out.println(days);
    }

    static int bfs(Queue<int[]> queue, int unripeCount) {
        int days = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            days = cur[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
                    map[nx][ny] = 1;
                    queue.add(new int[]{nx, ny, days + 1});
                    unripeCount--;
                }
            }
        }

        return unripeCount == 0 ? days : -1;
    }
}
