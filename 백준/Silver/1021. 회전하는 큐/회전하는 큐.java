import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cnt = 0;
        
        for (int i = 1; i <= N; i++) {
			dq.add(i);
		}
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			
			int idx = 0;
			
			for(int n : dq) {
				if(n == tmp) break;
				idx++;
			}
			
			if(idx <= dq.size() / 2) {
				while (dq.peek() != tmp) {
                    dq.addLast(dq.poll());
                    cnt++;
                }
			}
			else {
				while (dq.peek() != tmp) {
                    dq.addFirst(dq.pollLast());
                    cnt++;
                }
			}
			
			dq.poll();
		}
        System.out.println(cnt);
    }
}