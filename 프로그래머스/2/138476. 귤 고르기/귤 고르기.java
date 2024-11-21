import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Arrays.sort(tangerine);
        
        List<Integer> frequency = new ArrayList<>();
        int cnt = 1;
        
        for(int i=1;i<tangerine.length;i++){
            if(tangerine[i] == tangerine[i-1]){
                cnt++;
            }
            else{
                frequency.add(cnt);
                cnt = 1;
            }
        }
        frequency.add(cnt);
        
        frequency.sort(Collections.reverseOrder());
        
        int sum = 0;
        for(int n : frequency){
            sum += n;
            answer++;
            if(sum >= k) return answer;
        }
        
        return answer;
    }
}