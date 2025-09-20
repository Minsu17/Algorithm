import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Queue<Integer> q = new ArrayDeque<>();
        int last = arr[0];
        q.add(last);

        for (int i = 1; i < arr.length; i++) {
            if (last != arr[i]) {
                q.add(arr[i]);
                last = arr[i];
            }
        }

        int size = q.size();
        int[] answer = new int[size];
        for (int i = 0; i < size; i++) {
            answer[i] = q.poll();
        }

        return answer;
    }
}
