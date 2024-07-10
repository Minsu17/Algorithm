import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int chk = 0;
			int num = Integer.parseInt(st.nextToken());
			if(num < 2) continue;
			
			for (int j = 2; j <= Math.sqrt(num); j++) {
				if(num % j == 0) chk++;
				
			}
			if(chk == 0) cnt++;
		}
		System.out.println(cnt);
	}
}