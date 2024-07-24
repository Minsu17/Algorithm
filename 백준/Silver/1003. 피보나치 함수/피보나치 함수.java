import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int n;
	static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
			n = Integer.parseInt(br.readLine());
			dp = new int[n+2][2];
			dp[0][0] = 1;
			dp[0][1] = 0;
			dp[1][0] = 0;
			dp[1][1] = 1;
			
			for (int j = 2; j <= n; j++) {
				dp[j][0] = dp[j-2][0] + dp[j-1][0];
				dp[j][1] = dp[j-2][1] + dp[j-1][1];
			}
			sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
		}
        System.out.println(sb);
    }
}
