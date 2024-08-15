import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String name : participant){
            if(map.containsKey(name)){
                map.put(name, map.get(name) + 1);
            }
            else{
                map.put(name, 1);
            }
        }
        
        for(String name : completion){
            map.put(name, map.get(name) - 1);
        }
        
        for(String name : map.keySet()){
            if(map.get(name) > 0){
                answer += name;
            }
        }
        return answer;
    }
}