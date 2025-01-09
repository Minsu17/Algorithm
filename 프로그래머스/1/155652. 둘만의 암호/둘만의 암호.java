import java.util.*;

public class Solution {
    public static String solution(String s, String skip, int index) {
        Set<Character> skipSet = new HashSet<>();
        for (char ch : skip.toCharArray()) {
            skipSet.add(ch);
        }

        StringBuilder result = new StringBuilder();

        for (char ch : s.toCharArray()) {
            char current = ch;
            int steps = 0;

            while (steps < index) {
                current++;
                if (current > 'z') {
                    current = 'a';
                }
                if (!skipSet.contains(current)) {
                    steps++;
                }
            }

            result.append(current);
        }

        return result.toString();
    }
}