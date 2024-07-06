import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int x = a;
			int y = b;
			int r;
			// a와 b의 최대공약수 구하기
			while(a % b != 0) {
				r = a % b;
				a = b;
				b = r;
			}
			//두 수의 곱을 최대공약수로 나눈 값
			System.out.println(x*y/b);
		}
	}
}