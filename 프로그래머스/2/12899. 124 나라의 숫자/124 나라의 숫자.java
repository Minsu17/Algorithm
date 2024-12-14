class Solution {
    public String solution(int n) {
        String answer = "";
        
        while(true){
            if(n <= 0) break;
            if(n % 3 == 0){
                answer = 4 + answer;
                n  = n / 3 - 1;
            }
            else if(n % 3 == 1){
                answer = 1 + answer;
                n /= 3;
            }
            else{
                answer = 2 + answer;
                n /= 3;
            }
        }
        
        return answer;
    }
}