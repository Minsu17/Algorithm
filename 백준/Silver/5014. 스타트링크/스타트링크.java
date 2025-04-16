import java.io.*;
import java.util.*;

public class Main {
    static int F, S, G, U, D;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new int[F + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(S);
        visited[S] = 1;

        while (!q.isEmpty()) {
            int x = q.poll();

            if (x == G) {
                System.out.println(visited[x] - 1);
                return;
            }

            int up = x + U;
            if (U > 0 && up <= F && visited[up] == 0) {
                visited[up] = visited[x] + 1;
                q.offer(up);
            }

            int down = x - D;
            if (D > 0 && down >= 1 && visited[down] == 0) {
                visited[down] = visited[x] + 1;
                q.offer(down);
            }
        }

        System.out.println("use the stairs");
    }
}
