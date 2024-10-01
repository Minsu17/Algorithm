import java.util.HashSet;
import java.util.Set;

class Solution {
    static Set<Integer> primeSet = new HashSet<>(); // 소수를 저장할 Set
    static boolean[] visited; // 방문 여부를 체크하는 배열
    static int[] nums; // 문자열의 숫자를 저장하는 배열

    public int solution(String numbers) {
        // 입력된 문자열의 길이에 맞춰 방문 배열과 숫자 배열 초기화
        visited = new boolean[numbers.length()];
        nums = new int[numbers.length()];

        for (int i = 0; i < numbers.length(); i++) {
            nums[i] = numbers.charAt(i) - '0';
        }

        // 백트래킹으로 모든 숫자 조합을 생성하고 소수를 찾아냄
        backtracking("", 0);

        // 소수의 개수를 반환
        return primeSet.size();
    }

    // 백트래킹으로 가능한 숫자 조합을 생성하는 함수
    static void backtracking(String current, int depth) {
        // 현재 숫자 조합이 소수이면 Set에 추가
        if (!current.isEmpty()) {
            int num = Integer.parseInt(current);
            if (isPrime(num)) {
                primeSet.add(num); // 중복 방지를 위해 HashSet 사용
            }
        }

        // 모든 자리를 방문한 경우 종료
        if (depth == nums.length) return;

        // 각 자리의 숫자를 방문하면서 백트래킹 수행
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(current + nums[i], depth + 1);
                visited[i] = false;
            }
        }
    }

    // 소수 판별 함수
    static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
