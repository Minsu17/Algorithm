import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        long totalDigits = 0;
        long start = 1;
        long length = 1;
        
        while (start <= N) {
            long end = Math.min(N, (long)Math.pow(10, length) - 1);
            
            long count = end - start + 1;
            
            totalDigits += count * length;
            
            start = end + 1;
            length++;
        }
        
        System.out.println(totalDigits);
    }
}