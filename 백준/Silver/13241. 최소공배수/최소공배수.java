import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
			StringTokenizer st = new StringTokenizer(br.readLine());
			long a = Integer.parseInt(st.nextToken());
			long b = Integer.parseInt(st.nextToken());
			long x = a;
			long y = b;
			long r;
			while(a % b != 0) {
				r = a % b;
				a = b;
				b = r;
			}
			System.out.println(x*y/b);
	}
}