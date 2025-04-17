import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String kingStr = st.nextToken();
        String stoneStr = st.nextToken();
        int N = Integer.parseInt(st.nextToken());

        Map<String, int[]> dirMap = new HashMap<>();
        dirMap.put("R", new int[]{1, 0});
        dirMap.put("L", new int[]{-1, 0});
        dirMap.put("B", new int[]{0, -1});
        dirMap.put("T", new int[]{0, 1});
        dirMap.put("RT", new int[]{1, 1});
        dirMap.put("LT", new int[]{-1, 1});
        dirMap.put("RB", new int[]{1, -1});
        dirMap.put("LB", new int[]{-1, -1});

        int[] king = new int[]{kingStr.charAt(0) - 'A', kingStr.charAt(1) - '1'};
        int[] stone = new int[]{stoneStr.charAt(0) - 'A', stoneStr.charAt(1) - '1'};

        for (int i = 0; i < N; i++) {
            String move = br.readLine();
            int[] d = dirMap.get(move);

            int nx = king[0] + d[0];
            int ny = king[1] + d[1];

            if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8) continue;

            if (nx == stone[0] && ny == stone[1]) {
                int nsx = stone[0] + d[0];
                int nsy = stone[1] + d[1];
                if (nsx < 0 || nsx >= 8 || nsy < 0 || nsy >= 8) continue;
                stone[0] = nsx;
                stone[1] = nsy;
            }

            king[0] = nx;
            king[1] = ny;
        }

        System.out.println((char) (king[0] + 'A') + "" + (king[1] + 1));
        System.out.println((char) (stone[0] + 'A') + "" + (stone[1] + 1));
    }
}
