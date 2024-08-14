import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> h = new HashSet<>();
        
        for(int i=0;i<nums.length;i++){
            h.add(nums[i]);
        }
        
        if(h.size() > nums.length/2){
            answer = nums.length/2;
        }
        else{
            answer = h.size();
        }
        return answer;
    }
}