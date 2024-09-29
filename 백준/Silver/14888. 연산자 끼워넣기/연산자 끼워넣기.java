import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] num;
    static int[] oper = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        num = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
        
        back(num[0], 1);

        System.out.println(max);
        System.out.println(min);
    }
    
    static void back(int sum, int idx)
    {
    	 if (idx == N) {
             max = Math.max(max, sum);
             min = Math.min(min, sum);
             return;
         }
    	 
         for (int i = 0; i < 4; i++) {
             if (oper[i] > 0) {
                 oper[i]--;
                 if (i == 0) back(sum + num[idx], idx + 1);
                 else if (i == 1) back(sum - num[idx], idx + 1);
                 else if (i == 2) back(sum * num[idx], idx + 1);
                 else if (i == 3) back(sum / num[idx], idx + 1);
                 oper[i]++;
             }
         }
    	 
    }
}