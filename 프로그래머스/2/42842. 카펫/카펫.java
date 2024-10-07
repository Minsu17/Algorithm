class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = brown + yellow;
        
        for(int i=1;i<=brown;i++){
            for(int j=1;j<=brown;j++){
                if((i-2)*(j-2) == yellow && sum == i*j){
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }
        }
        
        return answer;
    }
}