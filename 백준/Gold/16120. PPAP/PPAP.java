import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> st = new Stack<>();

        char[] c = br.readLine().toCharArray();

        for (char cc : c) {
            st.push(cc);

            if (st.size() >= 4) {
                if (st.get(st.size() - 4) == 'P' &&
                        st.get(st.size() - 3) == 'P' &&
                        st.get(st.size() - 2) == 'A' &&
                        st.get(st.size() - 1) == 'P') {

                    st.pop();
                    st.pop();
                    st.pop();
                    st.pop();
                    st.push('P');
                }
            }
        }

        if (st.size() == 1 && st.peek() == 'P') {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
    }
}