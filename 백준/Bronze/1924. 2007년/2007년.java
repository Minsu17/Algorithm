import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);

        int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        String[] days = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };

        int totalDays = 0;
        for (int i = 0; i < x - 1; i++) {
            totalDays += daysInMonth[i];
        }
        totalDays += y;

        System.out.println(days[totalDays % 7]);
    }
}
