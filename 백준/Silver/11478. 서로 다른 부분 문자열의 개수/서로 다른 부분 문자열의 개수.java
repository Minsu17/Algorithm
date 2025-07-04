import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        HashSet<String> set = new HashSet<>();

        int len = S.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                set.add(S.substring(i, j));
            }
        }

        System.out.println(set.size());
    }
}
