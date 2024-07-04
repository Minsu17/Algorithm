import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String N[] = br.readLine().split("");
		
		Arrays.sort(N, Comparator.reverseOrder()); //array 내림차순
		
		for(int i=0;i<N.length;i++) {
			System.out.print(N[i]);
		}
		
	}
}