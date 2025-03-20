import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 처리하기 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] grid = new int[N][M];
        int[][] dp = new int[N][M];

        // 지형 데이터 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // DP 배열 초기화
        dp[0][0] = grid[0][0];

        // 첫 번째 행 갱신 (왼쪽에서만 올 수 있음)
        for (int j = 1; j < M; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // DP 계산 (두 번째 행부터)
        for (int i = 1; i < N; i++) {
            int[] leftToRight = new int[M];
            int[] rightToLeft = new int[M];

            // 위에서 내려오는 값 먼저 업데이트
            leftToRight[0] = dp[i - 1][0] + grid[i][0];

            // 왼쪽 → 오른쪽 이동 갱신
            for (int j = 1; j < M; j++) {
                leftToRight[j] = Math.max(dp[i - 1][j], leftToRight[j - 1]) + grid[i][j];
            }

            // 오른쪽 → 왼쪽 이동 갱신
            rightToLeft[M - 1] = dp[i - 1][M - 1] + grid[i][M - 1];
            for (int j = M - 2; j >= 0; j--) {
                rightToLeft[j] = Math.max(dp[i - 1][j], rightToLeft[j + 1]) + grid[i][j];
            }

            // 최종 DP 배열 갱신
            for (int j = 0; j < M; j++) {
                dp[i][j] = Math.max(leftToRight[j], rightToLeft[j]);
            }
        }

        // 정답 출력
        System.out.println(dp[N - 1][M - 1]);
    }
}
