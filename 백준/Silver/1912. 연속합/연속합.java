import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {

	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int end = arr[0];
        int maxFar = arr[0];

        for (int i = 1; i < n; i++) {
            end = Math.max(arr[i], end + arr[i]);
            maxFar = Math.max(maxFar, end);
        }
		System.out.println(maxFar);
	}
}