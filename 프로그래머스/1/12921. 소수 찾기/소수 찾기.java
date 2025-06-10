class Solution {
    public int solution(int n) {
        boolean[] sieve = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            sieve[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {
            if (sieve[i]) {
                for (int j = i * i; j <= n; j += i) {
                    sieve[j] = false;
                }
            }
        }

        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (sieve[i]) {
                answer++;
            }
        }

        return answer;
    }
}
