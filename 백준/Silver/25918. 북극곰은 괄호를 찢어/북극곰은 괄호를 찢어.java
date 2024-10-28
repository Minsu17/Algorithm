import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = -1;

        if (N % 2 == 0) {
            char[] S = br.readLine().toCharArray();
            Stack<Character> st = new Stack<>();

            for (char c : S) {
                if (st.isEmpty() || st.peek() == c) {
                    st.push(c);
                } else {
                    st.pop();
                }
                answer = Math.max(answer, st.size());
            }

            if (!st.isEmpty()) {
                answer = -1;
            }
        }

        System.out.println(answer);
    }
}
