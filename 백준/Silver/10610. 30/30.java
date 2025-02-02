import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] n = br.readLine().toCharArray();
        int sum = 0;
        boolean hasZero = false;  // 0이 존재하는지 확인
        StringBuilder sb = new StringBuilder();

        for (char c : n) {
            int digit = c - '0'; // 문자 → 숫자 변환
            sum += digit;
            if (digit == 0) {
                hasZero = true;  // 0이 있으면 true 설정
            }
        }

        if (sum % 3 != 0 || !hasZero) {
            System.out.println(-1);
            return;
        }

        Arrays.sort(n);
        for (int i = n.length - 1; i >= 0; i--) {
            sb.append(n[i]);
        }

        System.out.println(sb.toString());
    }
}
