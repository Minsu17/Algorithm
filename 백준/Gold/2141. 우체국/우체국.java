import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long sum = 0;
        int[][] town = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            town[i][0] = x;
            town[i][1] = a;
            sum += a;
        }

        Arrays.sort(town, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        long curSum = 0;
        for (int i = 0; i < N; i++) {
            curSum += town[i][1];
            if (curSum >= (sum + 1) / 2) {
                System.out.println(town[i][0]);
                break;
            }
        }
    }
}