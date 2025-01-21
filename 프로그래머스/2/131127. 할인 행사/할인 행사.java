import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> wantMap = new HashMap<>();
            for (int j = 0; j < want.length; j++) {
                wantMap.put(want[j], number[j]);
            }

            for (int j = i; j < i + 10; j++) {
                wantMap.put(discount[j], wantMap.getOrDefault(discount[j], 0) - 1);
            }

            boolean isValid = true;
            for (int value : wantMap.values()) {
                if (value > 0) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                answer++;
            }
        }

        return answer;
    }
}
