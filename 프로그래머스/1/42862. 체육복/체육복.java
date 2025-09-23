class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] student = new int[n+1];
        
        for(int num : lost){
            student[num]--;
        }
        
        for(int num : reserve){
            student[num]++;
        }
        
        for(int i=1;i<n;i++){
            if(student[i] == -1 && student[i+1] == 1){
                student[i]++;
                student[i+1]--;
            }
            else if(student[i] == 1 && student[i+1] == -1){
                student[i]--;
                student[i+1]++;
            }
        }
        for(int i=1;i<student.length;i++){
            if(student[i] != -1) answer++;
        }
        return answer;
    }
}