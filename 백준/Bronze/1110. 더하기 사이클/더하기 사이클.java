import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num;
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		//n이 10보다 작을 시 10을곱해 두자리 수 만들기
		if(n < 10) n = n * 10;
		
		num = n;
		
		while(true) {
			num = num % 10 * 10 + (num / 10 + num % 10) % 10;
			cnt++;
			if(num == n) break;
		}
		
		System.out.println(cnt);
		}
		
	}