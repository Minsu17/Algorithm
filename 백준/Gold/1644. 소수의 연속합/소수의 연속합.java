import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static boolean[] isPrime;
    static List<Integer> prime = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        isPrime = new boolean[N + 1];
        
        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }
        
        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                prime.add(i);
            }
        }
        
        int ans = sumPrime(N);
        System.out.println(ans);
    }
    
    static int sumPrime(int n) {
        int cnt = 0;
        int sum = 0;
        int start = 0;
        int end = 0;
        
        while (end < prime.size()) {
            if (sum < n) {
                sum += prime.get(end++);
            } else if (sum > n) {
                sum -= prime.get(start++);
            } else {
                cnt++;
                sum += prime.get(end++) - prime.get(start++);
            }
        }

        // 남은 부분 합이 n과 같은 경우를 추가로 체크
        while (sum >= n) {
            if (sum == n) {
                cnt++;
            }
            sum -= prime.get(start++);
        }
        
        return cnt;
    }
}