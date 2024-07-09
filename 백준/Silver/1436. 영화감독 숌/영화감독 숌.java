import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int cnt = 0;
        int num = 666;
        while(true) {
        	String str = "" + num;
        	if(str.contains("666")) {
        		cnt++;
        	}
        	if(n == cnt) {
        		System.out.println(str);
        		break;
        	}
        	num++;
        }
        sc.close();
    }
}
