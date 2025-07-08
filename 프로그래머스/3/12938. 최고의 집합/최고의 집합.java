import java.util.*;

public class Solution {
    public int[] solution(int n, int s) {
        if (s < n) return new int[]{-1};

        int[] answer = new int[n];
        int avg = s / n;
        int rest = s % n;

        for (int i = 0; i < n; i++) {
            if (i < n - rest) {
                answer[i] = avg;
            } else {
                answer[i] = avg + 1;
            }
        }

        return answer;
    }
}
