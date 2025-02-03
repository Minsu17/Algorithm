import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] truck = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            truck[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> bridge = new ArrayDeque<>();
        int time = 0;
        int bridgeWeight = 0;

        for (int i = 0; i < w; i++) {
            bridge.offer(0);
        }

        int index = 0;
        while (index < n) {
            time++;
            bridgeWeight -= bridge.poll();

            if (bridgeWeight + truck[index] <= l) {
                bridge.offer(truck[index]);
                bridgeWeight += truck[index];
                index++;
            } else {
                bridge.offer(0);
            }
        }

        time += w;
        System.out.println(time);
    }
}
