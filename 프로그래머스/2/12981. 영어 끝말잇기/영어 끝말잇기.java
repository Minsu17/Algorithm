import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>();
        
        for(int i=0;i<words.length;i++){
            if(i > 0){
            String start = words[i].substring(0, 1);
            String end = words[i-1].substring(words[i-1]. length()-1);
            if(!start.equals(end) || set.contains(words[i])){
                
                answer[0] = i%n+1;
                answer[1] = i/n+1;
                break;
                }
            }
            set.add(words[i]);
        }

        return answer;
    }
}