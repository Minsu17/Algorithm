import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int rm = (int) Math.round(N * 0.15);
        int ans = 0;
        
        for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
        Arrays.sort(arr);
        for (int i = rm; i < arr.length-rm; i++) {
			ans += arr[i];
		}
        
        System.out.println(Math.round((double)ans/(N - rm * 2)));
        
    }
}