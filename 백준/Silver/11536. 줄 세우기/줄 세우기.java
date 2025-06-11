import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = br.readLine();
        }

        String[] ascending = names.clone();
        String[] descending = names.clone();
        Arrays.sort(ascending);
        Arrays.sort(descending, (a, b) -> b.compareTo(a));

        if (Arrays.equals(names, ascending)) {
            System.out.println("INCREASING");
        } else if (Arrays.equals(names, descending)) {
            System.out.println("DECREASING");
        } else {
            System.out.println("NEITHER");
        }
    }
}
