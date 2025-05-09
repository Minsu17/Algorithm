class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i=0;i<n;i++){
            int bin = arr1[i] | arr2[i];
            String str = Integer.toBinaryString(bin);
            
            
            while(str.length() < n){
                str = "0" + str;
            }
                String[] s = str.split("");
            StringBuilder sb = new StringBuilder();
            
            for(int j=0;j<n;j++){
                if(s[j].equals("1")){
                    sb.append("#");
                }
                else{
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}