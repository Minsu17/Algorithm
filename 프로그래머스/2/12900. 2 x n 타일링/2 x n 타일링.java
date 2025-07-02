class Solution {
    public int solution(int n) {
        int mod = 1_000_000_007;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int a = 1;
        int b = 2;
        int c = 0;

        for (int i = 3; i <= n; i++) {
            c = (a + b) % mod;
            a = b;
            b = c;
        }

        return c;
    }
}
