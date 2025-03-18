import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        Stack<Integer>[] guitar = new Stack[7];
        for (int i = 1; i <= 6; i++) {
            guitar[i] = new Stack<>();
        }

        int moves = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            int fret = Integer.parseInt(st.nextToken());

            while (!guitar[line].isEmpty() && guitar[line].peek() > fret) {
                guitar[line].pop();
                moves++;
            }

            if (!guitar[line].isEmpty() && guitar[line].peek() == fret) {
                continue;
            }

            guitar[line].push(fret);
            moves++;
        }

        System.out.println(moves);
    }
}
