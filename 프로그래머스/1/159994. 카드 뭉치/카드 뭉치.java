import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        
        Queue<String> q1 = new ArrayDeque<>();
        Queue<String> q2 = new ArrayDeque<>();
        
        for(int i=0;i<cards1.length;i++){
            q1.add(cards1[i]);
        }
        
        for(int i=0;i<cards2.length;i++){
            q2.add(cards2[i]);
        }
        int idx = 0;
        for (String card : goal) {
            if (!q1.isEmpty() && card.equals(q1.peek())) {
                q1.poll();
            }
            else if (!q2.isEmpty() && card.equals(q2.peek())) {
                q2.poll();
            }
            else {
                answer = "No";
            }
        }
            
        return answer;
    }
}