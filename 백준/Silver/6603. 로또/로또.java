import java.io.*;
import java.util.*;

public class Main {
    static int[] arr = new int[13];
    static int[] sel = new int[6];
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = br.readLine();
            if (line.equals("0")) break;

            StringTokenizer st = new StringTokenizer(line);
            k = Integer.parseInt(st.nextToken());
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0, sb);
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int start, int depth, StringBuilder sb) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(sel[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < k; i++) {
            sel[depth] = arr[i];
            dfs(i + 1, depth + 1, sb);
        }
    }
}
