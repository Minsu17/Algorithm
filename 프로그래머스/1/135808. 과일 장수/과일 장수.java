import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        int t = score.length-1;
        
        for(int i=0;i<score.length / m;i++){
            int min = 10;
            if(i >0){
                t -= m;
            }
            for(int j=t;j>t-m;j--){
                if(score[j] < min){
                    min = score[j];
                }
            }
            answer += m * min;
        }
        
        return answer;
    }
}