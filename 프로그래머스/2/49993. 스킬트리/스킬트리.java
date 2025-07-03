import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (String tree : skill_trees) {
            Deque<Character> dq = new ArrayDeque<>();

            for (char c : skill.toCharArray()) {
                dq.add(c);
            }

            boolean valid = true;

            for (char ch : tree.toCharArray()) {
                if (dq.contains(ch)) {
                    if (ch != dq.peek()) {
                        valid = false;
                        break;
                    } else {
                        dq.poll();
                    }
                }
            }

            if (valid) answer++;
        }
        
        return answer;
    }
}