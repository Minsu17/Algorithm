import java.util.*;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> daysQueue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int remain = (100 - progresses[i]);
            int days = (int) Math.ceil((double) remain / speeds[i]);
            daysQueue.add(days);
        }

        int current = daysQueue.poll();
        int count = 1;

        while (!daysQueue.isEmpty()) {
            int next = daysQueue.poll();
            if (next <= current) {
                count++;
            } else {
                result.add(count);
                count = 1;
                current = next;
            }
        }
        result.add(count);

        return result.stream().mapToInt(i -> i).toArray();
    }
}
