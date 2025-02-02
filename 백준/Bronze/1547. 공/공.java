import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int ballPosition = 1;

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cup1 = Integer.parseInt(st.nextToken());
            int cup2 = Integer.parseInt(st.nextToken());

            if (ballPosition == cup1) {
                ballPosition = cup2;
            } else if (ballPosition == cup2) {
                ballPosition = cup1;
            }
        }
        System.out.println(ballPosition);

    }
}
