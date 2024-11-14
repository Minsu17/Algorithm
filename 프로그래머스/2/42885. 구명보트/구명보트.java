import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int light = 0;
        int heavy = people.length - 1;
        
        for(int i=heavy;i>=light;i--){
            if(people[i] + people[light] <= limit){
                light++;
            }
            answer++;
        }
        return answer;
    }
}