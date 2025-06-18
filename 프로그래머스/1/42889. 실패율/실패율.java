import java.util.*;

class Solution {
    public int[] solution(int n, int[] s) {
        int[] cnt = new int[n + 2];
        for (int v : s) cnt[v]++;

        double[] fail = new double[n + 1];
        int remain = s.length;
        for (int i = 1; i <= n; i++) {
            fail[i] = remain > 0 ? (double) cnt[i] / remain : 0;
            remain -= cnt[i];
        }

        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i + 1;

        Arrays.sort(idx, (a, b) ->
            fail[b] == fail[a] ? a - b : Double.compare(fail[b], fail[a])
        );

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) answer[i] = idx[i];
        return answer;
    }
}
