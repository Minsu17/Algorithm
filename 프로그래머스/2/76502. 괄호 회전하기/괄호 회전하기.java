import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int x = s.length();
        
        for(int i=0;i<x;i++){
        Stack<Character> st = new Stack<>();
            boolean check = true;
            
            for(int j=0;j<x;j++){
                char c = s.charAt(j);
                
                if(c == '(' || c == '[' || c == '{'){
                    st.add(c);
                }
                else{
                    if(st.isEmpty()){
                        check = false;
                        break;
                    }
                    
                    char tmp = st.pop();
                    if ((c == ')' && tmp != '(') || 
                        (c == ']' && tmp != '[') || 
                        (c == '}' && tmp != '{')) {
                        check = false;
                        break;
                    }
                }
            }
            if(check && st.isEmpty()) answer++;
            //문자열 왼쪽으로 한칸 회전
            s = s.substring(1) + s.charAt(0);
        }
        return answer;
    }
}