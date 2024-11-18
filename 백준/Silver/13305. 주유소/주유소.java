import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] road = new int[N-1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N-1; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }

        int[] price = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        int totalCost = 0;
        int minPrice = price[0];

        for (int i = 0; i < N - 1; i++) {
            // 현재까지의 최소 기름값으로 주유
            totalCost += minPrice * road[i];

            // 다음 도시의 기름값과 비교
            if (price[i + 1] < minPrice) {
                minPrice = price[i + 1];
            }
        }

        System.out.println(totalCost);
    }

}
