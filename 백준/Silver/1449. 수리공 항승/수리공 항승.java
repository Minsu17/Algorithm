import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] leaks = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            leaks[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(leaks);

        int count = 0;
        int i = 0;

        while (i < N) {
            count++;
            int tapeEnd = leaks[i] + L - 1;
            
            while (i < N && leaks[i] <= tapeEnd) {
                i++;
            }
        }

        System.out.println(count);
    }
}
