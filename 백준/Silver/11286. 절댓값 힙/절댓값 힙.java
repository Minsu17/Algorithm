import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> absHeap = new PriorityQueue<>((e1, e2) -> {
        	if(Math.abs(e1) == Math.abs(e2)) {
        		return e1 - e2;
        	}
        	else {
        		return Math.abs(e1) - Math.abs(e2);
        	}
        });
        
        int N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int tmp = Integer.parseInt(st.nextToken());
			if(tmp != 0) {
				absHeap.add(tmp);
			}
			else {
				if(absHeap.isEmpty()) {
					System.out.println(0);
				}
				else {
					System.out.println(absHeap.poll());
				}
			}
		}
    }
}