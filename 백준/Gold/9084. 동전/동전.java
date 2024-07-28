import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] cost = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<cost.length;j++) {
				cost[j] = Integer.parseInt(st.nextToken());
			}
			
			int M = Integer.parseInt(br.readLine());
			int[] dp = new int[M+1];
			
			for (int j = 0; j < N; j++) {
				for (int k = 1; k <= M; k++) {
					if(k - cost[j] > 0){
						dp[k] += dp[k - cost[j]];
					}
					else if(k - cost[j] == 0){
						dp[k]++;
					}
				}
			}
			
			System.out.println(dp[M]);
		}
	}
}