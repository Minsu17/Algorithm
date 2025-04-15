import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] tallerCounts = new int[N];
        for (int i = 0; i < N; i++) {
            tallerCounts[i] = Integer.parseInt(st.nextToken());
        }

        LinkedList<Integer> lineup = new LinkedList<>();
        for (int height = N; height >= 1; height--) {
            int count = tallerCounts[height - 1];
            lineup.add(count, height);
        }

        for (int h : lineup) {
            System.out.print(h + " ");
        }
    }
}
