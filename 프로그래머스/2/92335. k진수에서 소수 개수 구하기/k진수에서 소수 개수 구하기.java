class Solution {
    public int solution(int n, int k) {
        String baseK = Integer.toString(n, k);
        String[] parts = baseK.split("0+");
        int count = 0;

        for (String part : parts) {
            if (part.isEmpty()) continue;
            long num = Long.parseLong(part);
            if (isPrime(num)) count++;
        }

        return count;
    }

    private boolean isPrime(long num) {
        if (num < 2) return false;
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
