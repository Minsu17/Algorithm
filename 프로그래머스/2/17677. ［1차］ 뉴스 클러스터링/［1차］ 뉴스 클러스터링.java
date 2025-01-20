import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        ArrayList<String> arr1 = new ArrayList<>();
        ArrayList<String> arr2 = new ArrayList<>();
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        // 두 글자씩 나누는 부분 수정
        for (int i = 0; i < str1.length() - 1; i++) {
            String tmp = str1.substring(i, i + 2);
            if (tmp.matches("[a-zA-Z]{2}")) {
                arr1.add(tmp);
            }
        }
        
        for (int i = 0; i < str2.length() - 1; i++) {
            String tmp = str2.substring(i, i + 2);
            if (tmp.matches("[a-zA-Z]{2}")) {
                arr2.add(tmp);
            }
        }
        
        double intersection = 0;
        double union = arr1.size() + arr2.size();
        
        ArrayList<String> tempArr2 = new ArrayList<>(arr2);
        
        for (String s : arr1) {
            if (tempArr2.contains(s)) {
                intersection++;
                tempArr2.remove(s);
            }
        }
        
        if (intersection == 0 && union == 0) {
            answer = 65536;
        } else {
            answer = (int) (intersection / (union - intersection) * 65536);
        }
        
        return answer;
    }
}
