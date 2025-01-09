import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0; // 총 실행 시간
        LinkedList<String> cache = new LinkedList<>();

        for (String city : cities) {
            String cityLowerCase = city.toLowerCase();

            if (cache.contains(cityLowerCase)) { // cache hit
                cache.remove(cityLowerCase);
                cache.addFirst(cityLowerCase);
                answer += 1;
            }
            else { // cache miss
                if (cache.size() == cacheSize && cacheSize > 0) {
                    cache.removeLast();
                }
                if (cacheSize > 0) {
                    cache.addFirst(cityLowerCase);
                }
                answer += 5;
            }
        }

        return answer;
    }
}
