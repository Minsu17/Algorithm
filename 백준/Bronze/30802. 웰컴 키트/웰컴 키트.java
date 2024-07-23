import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
		int[] a = new int[6];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 6; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		for(int i = 0; i < 6; i++) {
			cnt += a[i] / t;
			if(a[i] % t != 0) {
				cnt++;
			}
		}
		System.out.println(cnt);
		System.out.println(n / p + " " + n % p);
        
    }
    
}
