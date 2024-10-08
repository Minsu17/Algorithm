import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> st = new Stack<>();
        
        int k = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                st.push(num);
            } else if (!st.isEmpty()) {
                st.pop();
            }
        }
        
        int ans = 0;
        for (int n : st) {
            ans += n;
        }
        
        System.out.println(ans);
        
    }
}
