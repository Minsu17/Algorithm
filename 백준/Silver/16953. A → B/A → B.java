import java.util.*;
import java.io.*;

public class Main {
	
	private static long dfs(long A, long B) {
		Queue<Long> q = new LinkedList<>();
		Queue<Long> cnt = new LinkedList<>();
		
		q.offer(A);
		cnt.offer(0L);
		
		while(!q.isEmpty()) {
			long cur = q.poll();
			long count = cnt.poll();
			
			if(cur == B) {
				return count;
			}
			
			long dble = cur * 2;
			if(dble <= B) {
				q.offer(dble);
				cnt.offer(count + 1);
			}
			
			long app = Long.parseLong(String.valueOf(cur) + "1");
			if(app <= B) {
				q.offer(app);
				cnt.offer(count + 1);
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] arr = br.readLine().split(" ");
		long A = Long.parseLong(arr[0]);
		long B = Long.parseLong(arr[1]);
		
		
		long cnt = dfs(A, B);
		
		if(cnt == -1) {
			System.out.println(-1);
		}
		else {
			System.out.println(cnt + 1);
		}
		br.close();
	}
}