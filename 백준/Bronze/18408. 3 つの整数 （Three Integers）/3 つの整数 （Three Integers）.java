import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int zero = 0;
		int one = 0;
		if(a == 1) {
			one++;
		}
		else {
			zero++;
		}
		if(b == 1) {
			one++;
		}
		else {
			zero++;
		}
		if(c == 1) {
			one++;
		}
		else {
			zero++;
		}
		if(one > zero) {
			System.out.println(1);
		}
		else {
			System.out.println(2);
		}
		
		sc.close();
	}
}