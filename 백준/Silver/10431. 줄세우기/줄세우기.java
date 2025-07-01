import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int P = Integer.parseInt(br.readLine());

        for (int i = 0; i < P; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int[] heights = new int[20];
            for (int j = 0; j < 20; j++) {
                heights[j] = Integer.parseInt(st.nextToken());
            }

            List<Integer> line = new ArrayList<>();
            int totalSteps = 0;

            line.add(heights[0]); 

            for (int k = 1; k < 20; k++) {
                int currentH = heights[k];
                boolean placed = false;
                
                for (int l = 0; l < line.size(); l++) {
                    if (line.get(l) > currentH) {
                        line.add(l, currentH);
                        totalSteps += (line.size() - 1 - l); 
                        placed = true;
                        break;
                    }
                }
                
                if (!placed) {
                    line.add(currentH);
                }
            }
            sb.append(T).append(" ").append(totalSteps).append("\n");
        }

        br.close();
        System.out.print(sb.toString());
    }
}