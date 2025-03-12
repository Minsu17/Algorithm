import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int pMin = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int packagePrice = Integer.parseInt(st.nextToken());
            int singlePrice = Integer.parseInt(st.nextToken());

            pMin = Math.min(pMin, packagePrice);
            min = Math.min(min, singlePrice);
        }

        int option1 = (n / 6) * pMin;
        if (n % 6 > 0) {
            option1 += pMin;
        }

        int option2 = n * min;
        
        int option3 = (n / 6) * pMin + (n % 6) * min;

        int result = Math.min(option1, Math.min(option2, option3));
        System.out.println(result);
    }
}
