import java.util.*;

public class Solution {
    public int[] solution(int []arr) {

        ArrayList<Integer> answerList = new ArrayList<>();
        
        answerList.add(arr[0]);
        
        for(int i=1;i<arr.length;i++){
            if(arr[i] != arr[i - 1]){
                answerList.add(arr[i]);
            }
        }
        int answer[] = new int[answerList.size()];
        for(int i=0;i<answerList.size();i++){
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}