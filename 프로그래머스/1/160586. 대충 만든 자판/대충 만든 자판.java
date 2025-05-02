import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> map = new HashMap<>();

        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                int press = i + 1;
                if (!map.containsKey(c) || map.get(c) > press) {
                    map.put(c, press);
                }
            }
        }

        int[] answer = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            int count = 0;
            for (char c : targets[i].toCharArray()) {
                if (map.containsKey(c)) {
                    count += map.get(c);
                } else {
                    count = -1;
                    break;
                }
            }
            answer[i] = count;
        }

        return answer;
    }
}
