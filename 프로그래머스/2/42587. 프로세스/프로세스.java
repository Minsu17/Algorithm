import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] priorityInput = br.readLine().split(" ");
        int[] priorities = new int[priorityInput.length];
        for (int i = 0; i < priorityInput.length; i++) {
            priorities[i] = Integer.parseInt(priorityInput[i]);
        }

        int location = Integer.parseInt(br.readLine());

        int result = solution(priorities, location);
        System.out.println(result);
    }

    public static int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{i, priorities[i]});
        }

        int count = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            boolean hasHigher = false;

            for (int[] q : queue) {
                if (q[1] > current[1]) {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) {
                queue.add(current);
            } else {
                count++;
                if (current[0] == location) {
                    return count;
                }
            }
        }

        return -1;
    }
}
