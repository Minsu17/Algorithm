import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] button = new int[n+1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < button.length; i++) {
			button[i] = Integer.parseInt(st.nextToken());
		}
        
        int student = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < student; i++) {
			st = new StringTokenizer(br.readLine());
			int xy = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if(xy == 1) {
				for(int j=num;j<=n;j+=num) {
					button[j] = 1 - button[j];
				}
			}
			else {
				int left = num;
                int right = num;
                
                while (left > 1 && right < n && button[left - 1] == button[right + 1]) {
                    left--;
                    right++;
                }
                
                for (int j = left; j <= right; j++) {
                    button[j] = 1 - button[j];
                }
			}
		}
        
        for (int i = 1; i < button.length; i++) {
        	System.out.print(button[i] + " ");
        	if(i % 20 == 0) System.out.println();
		}
    }
}