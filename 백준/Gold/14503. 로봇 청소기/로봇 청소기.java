import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 방향: 북(0), 동(1), 남(2), 서(3)
    static int[] dr = {-1, 0, 1, 0}; // 북, 동, 남, 서 (r 이동)
    static int[] dc = {0, 1, 0, -1}; // 북, 동, 남, 서 (c 이동)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] room = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        boolean running = true;

        while (running) {
            // 1. 현재 칸이 청소되지 않았다면 청소
            if (room[r][c] == 0) {
                room[r][c] = 2; // 청소한 칸을 2로 표시
                cnt++;
            }

            // 2. 네 방향 모두 청소되었거나 벽이면 후진 시도
            boolean allCleaned = true;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (room[nr][nc] == 0) { // 청소할 곳이 남아 있음
                    allCleaned = false;
                    break;
                }
            }

            if (allCleaned) {
                // 후진 방향 계산
                int backDir = (d + 2) % 4; // 현재 방향의 반대
                int rr = r + dr[backDir];
                int bc = c + dc[backDir];

                if (room[rr][bc] != 1) { // 후진 가능하면 후진
                    r = rr;
                    c = bc;
                } else { // 후진 불가능하면 작동 종료
                    running = false;
                }
                continue;
            }

            // 3. 네 방향 중 청소되지 않은 곳이 있으면 반시계 방향으로 회전 후 전진
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4; // 반시계 방향 회전
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (room[nr][nc] == 0) { // 청소되지 않은 칸이 있으면 전진
                    r = nr;
                    c = nc;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}
