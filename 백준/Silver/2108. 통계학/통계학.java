import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		int num[] = new int[8001];
		int sum = 0;
		int max = -4000;
		int min = 4000;
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		for(int i=0;i<n;i++) {
			sum += arr[i];
			if(arr[i]>max) {
				max = arr[i];
			}
			if(arr[i]<min) {
				min = arr[i];
			}
			num[arr[i] + 4000]++;
		}
		int tmp = 0;
		int result = 0;
		for(int i=0;i<num.length;i++) {
			if(tmp < num[i]) {
				tmp = num[i];
				result = i - 4000;
			}
		}
		int cnt = 0;
		for(int i=0;i<num.length;i++) {
			if(tmp == num[i]) {
				result = i - 4000;
				if(cnt == 1) {
					break;
				}
				cnt++;
			}
		}
		
		System.out.println(Math.round((double)sum / n));
		System.out.println(arr[n/2]);
		System.out.println(result);
		System.out.println(max - min);
	}
}