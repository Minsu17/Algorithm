import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());

        List<Integer> horizontalCuts = new ArrayList<>();
        List<Integer> verticalCuts = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());

            if (dir == 0) {
                horizontalCuts.add(pos);
            } else {
                verticalCuts.add(pos);
            }
        }

        horizontalCuts.add(0);
        horizontalCuts.add(height);
        verticalCuts.add(0);
        verticalCuts.add(width);

        Collections.sort(horizontalCuts);
        Collections.sort(verticalCuts);

        int maxH = 0;
        for (int i = 1; i < horizontalCuts.size(); i++) {
            int h = horizontalCuts.get(i) - horizontalCuts.get(i - 1);
            maxH = Math.max(maxH, h);
        }

        int maxW = 0;
        for (int i = 1; i < verticalCuts.size(); i++) {
            int w = verticalCuts.get(i) - verticalCuts.get(i - 1);
            maxW = Math.max(maxW, w);
        }

        System.out.println(maxH * maxW);
    }
}
