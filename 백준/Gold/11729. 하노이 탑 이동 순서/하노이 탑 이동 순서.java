import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    static StringBuilder result = new StringBuilder();
    static int move = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        hanoi(N, 1, 2, 3);

        System.out.println(move);
        System.out.print(result.toString());
    }

    public static void hanoi(int n, int start, int mid, int end) {
        if (n == 1) {
            // 원판이 1개일 때 바로 이동
            result.append(start).append(" ").append(end).append("\n");
            move++;
            return;
        }

        // 원판 n-1개를 시작점에서 중간으로 이동
        hanoi(n - 1, start, end, mid);

        // 가장 큰 원판을 시작점에서 끝점으로 이동
        result.append(start).append(" ").append(end).append("\n");
        move++;

        // 원판 n-1개를 중간에서 끝점으로 이동
        hanoi(n - 1, mid, start, end);
    }
}
