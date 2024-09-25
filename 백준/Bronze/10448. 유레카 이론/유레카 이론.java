import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] arr = new int[1000];
        int size = 0;
        for (int i = 1; ; i++) {
            int tmp = i * (i + 1) / 2;
            if (tmp > 1000) break;
            arr[size++] = tmp;
        }

        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine());
            System.out.println(sum(K, arr, size) ? 1 : 0);
        }
    }

    private static boolean sum(int K, int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                for (int k = j; k < size; k++) {
                    if (arr[i] + arr[j] + arr[k] == K) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
