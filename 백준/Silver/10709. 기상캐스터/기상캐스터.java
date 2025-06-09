import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] hw = br.readLine().split(" ");
        int H = Integer.parseInt(hw[0]);
        int W = Integer.parseInt(hw[1]);

        String[] map = new String[H];
        for (int i = 0; i < H; i++) {
            map[i] = br.readLine();
        }

        int[][] result = new int[H][W];

        for (int i = 0; i < H; i++) {
            int time = -1;
            for (int j = 0; j < W; j++) {
                if (map[i].charAt(j) == 'c') {
                    time = 0;
                    result[i][j] = time;
                } else {
                    if (time == -1) {
                        result[i][j] = -1;
                    } else {
                        time++;
                        result[i][j] = time;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                sb.append(result[i][j]);
                if (j < W - 1) sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
