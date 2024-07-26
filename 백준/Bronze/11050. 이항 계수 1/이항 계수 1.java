import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.io.IOException;

public class Main {

    // 팩토리얼
    private static BigInteger fact(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    // 이항 계수
    private static BigInteger binom(int n, int k) {
        if (k > n) return BigInteger.ZERO;
        if (k == 0 || k == n) return BigInteger.ONE;
        BigInteger num = fact(n);
        BigInteger den = fact(k).multiply(fact(n - k));
        return num.divide(den);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        
        BigInteger result = binom(n, k);
        System.out.println(result);
    }
}