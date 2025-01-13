class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        int[] answer = new int[2];
        int cnt = 0;
        int zeroCnt = 0;
        
        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCnt++;
            } else {
                for (int win : win_nums) {
                    if (lotto == win) {
                        cnt++;
                        break;
                    }
                }
            }
        }
        
        answer[0] = getRank(cnt + zeroCnt);
        answer[1] = getRank(cnt);
        
        return answer;
    }
    
    private int getRank(int count) {
        if (count == 6) return 1;
        if (count == 5) return 2;
        if (count == 4) return 3;
        if (count == 3) return 4;
        if (count == 2) return 5;
        return 6;
    }
}
