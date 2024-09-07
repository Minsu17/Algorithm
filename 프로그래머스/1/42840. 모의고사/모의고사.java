import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int acnt = 0;
        int bcnt = 0;
        int ccnt = 0;
        
        for(int i=0;i<answers.length;i++){
            if(answers[i] == a[i % a.length]){
                acnt++;
            }
            if(answers[i] == b[i % b.length]){
                bcnt++;
            }
            if(answers[i] == c[i % c.length]){
                ccnt++;
            }
        }
        int max = Math.max(acnt, Math.max(bcnt, ccnt));
        
        if(max == acnt){
            answer.add(1);
        }
        if(max == bcnt){
            answer.add(2);
        }
        if(max == ccnt){
            answer.add(3);
        }
        return answer;
    }
}