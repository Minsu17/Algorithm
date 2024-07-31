import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int[] students = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }
        
        int current = 1;
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() == current) {
                stack.pop();
                current++;
            }
            
            if (students[i] == current) {
                current++;
            } else {
                stack.push(students[i]);
            }
        }
        
        while (!stack.isEmpty() && stack.peek() == current) {
            stack.pop();
            current++;
        }
        
        if (current - 1 == n) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}
