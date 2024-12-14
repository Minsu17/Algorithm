class Solution {
    public int solution(String s) {
        int answer = 0;
        int sameCnt = 0;
        int difCnt = 0;
        char x = s.charAt(0);
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == x) {
                sameCnt++;
            } else {
                difCnt++;
            }
            
            if (sameCnt == difCnt) {
                answer++;
                if (i + 1 < s.length()) {
                    x = s.charAt(i + 1);
                }
                sameCnt = 0;
                difCnt = 0;
            }
        }
        
        if (sameCnt != 0 || difCnt != 0) {
            answer++;
        }
        
        return answer;
    }
}
