import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] arr;
	static boolean[] use;
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N+1];
        use = new boolean[N+1];
        for (int i = 0; i < N; i++) {
			arr[i] = i;
		}
        back(0);
        System.out.println(sb);
    }
    
    static void back(int idx) {
    	if(idx == M) {
    		for (int i = 1; i < idx+1; i++) {
				sb.append(arr[i] + " ");
			}
    		sb.append("\n");
    		return;
    	}
    	
    	for (int i = 1; i < N + 1; i++) {
			if(!use[i]) {
				use[i] = true;
				arr[idx+1] = i;
				back(idx+1);
				
				use[i] = false;
			}
		}
    }
}