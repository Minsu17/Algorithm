import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        int[] alphaWeights = new int[26];

        for (String word : words) {
            int power = 1;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                alphaWeights[c - 'A'] += power;
                power *= 10;
            }
        }

        Arrays.sort(alphaWeights);

        int num = 9;
        int result = 0;
        for (int i = 25; i >= 0; i--) {
            if (alphaWeights[i] == 0) break;
            result += alphaWeights[i] * num;
            num--;
        }

        System.out.println(result);
    }
}
