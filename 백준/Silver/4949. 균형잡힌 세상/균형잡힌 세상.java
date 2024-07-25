import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            String s = br.readLine();
            if (s.equals(".")) break;
            
            Stack<Character> st = new Stack<>();
            
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                
                if (ch == '(' || ch == '[') {
                    st.push(ch);
                } else if (ch == ')') {
                    if (st.isEmpty() || st.peek() != '(') {
                        st.push(ch);
                        break;
                    }
                    st.pop();
                } else if (ch == ']') {
                    if (st.isEmpty() || st.peek() != '[') {
                        st.push(ch);
                        break;
                    }
                    st.pop();
                }
            }
            
            if (st.isEmpty()) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }
        
        System.out.print(sb);
    }
}