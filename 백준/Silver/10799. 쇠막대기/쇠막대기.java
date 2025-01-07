import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> st = new Stack<>();

        String s = br.readLine();
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push('(');
            }
            else {
                st.pop();
                if (s.charAt(i - 1) == ')') {
                    ans++;
                } else {
                    ans += st.size();
                }
            }
        }
        System.out.println(ans);
    }
}