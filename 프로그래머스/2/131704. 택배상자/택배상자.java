import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        int current = 1;
        int count = 0;

        while (true) {
            if (current <= order.length && current == order[idx]) {
                count++;
                idx++;
                current++;
            } else if (!stack.isEmpty() && stack.peek() == order[idx]) {
                stack.pop();
                count++;
                idx++;
            } else if (current <= order.length) {
                stack.push(current++);
            } else {
                break;
            }
        }

        return count;
    }
}
