import java.io.*;
import java.util.*;

public class Main{
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int result = 0;
        long[] arr = new long[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int cnt=0;
        int i = 0;
        int j = n-1;
        while(i < j) {
        	if(arr[i] + arr[j] < m) {
        		i++;
        	}
        	else if(arr[i] + arr[j] > m) {
        		j--;
        	}
        	else {
        		cnt++;
        		i++;
        		j--;
        	}
        }
        System.out.println(cnt);
    }
    
}
