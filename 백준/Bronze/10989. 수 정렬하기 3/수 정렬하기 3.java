import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] count = new int[10001];
	
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0;i<arr.length;i++) {
			count[arr[i]]++;
			
		}
		for(int i=0;i<count.length;i++) {
			if(count[i] != 0) {
				for(int j=0;j<count[i];j++) {
					bw.write(Integer.toString(i) + "\n");
				}
			}
		}
		bw.flush();
	}
}