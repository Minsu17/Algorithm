import java.util.*;
class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2).replace("},{", "-");
        String[] sets = s.split("-");

        Arrays.sort(sets, (a, b) -> a.length() - b.length());

        List<Integer> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        for (String set : sets) {
            for (String numStr : set.split(",")) {
                int num = Integer.parseInt(numStr);
                if (seen.add(num)) {
                    result.add(num);
                }
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}
