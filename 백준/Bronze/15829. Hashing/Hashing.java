import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int L = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        
        long sum = 0;
        long r = 31;
        long M = 1234567891;
        long rPower = 1;
        
        for (int i = 0; i < L; i++) {
            int charValue = arr[i] - 'a' + 1;
            sum = (sum + charValue * rPower) % M;
            rPower = (rPower * r) % M;
        }
        
        System.out.println(sum);
    }
}