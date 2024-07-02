import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String arr[] = br.readLine().split("");
		
		Arrays.sort(arr, Comparator.reverseOrder());
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]);
		}
		
	}
}