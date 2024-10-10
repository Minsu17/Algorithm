class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] lang = {"aya", "ye", "woo", "ma"};
        
        for (int i=0;i<babbling.length;i++) {
            String word = babbling[i];
            boolean check = true;
            
            for (int j = 0; j < lang.length; j++) {
                if (word.contains(lang[j] + lang[j])) {
                    check = false;
                    break;
                }
            }
            
            if (!check) continue;
            
            for (String babble : lang) {
                word = word.replace(babble, " ");
            }
            
            if (word.trim().isEmpty()) {
                answer++;
            }
        }
        
        return answer;
    }
}
