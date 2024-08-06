import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0;i<numbers.length - 1;i++){
            int sum = 0;
            for(int j=i+1;j<numbers.length;j++){
                sum = numbers[i] + numbers[j];
                list.add(sum);
            }
        }
        for (int i = list.size() - 1; i >= 0; i--) {
             for (int j = i - 1; j >= 0; j--) {
                if (list.get(i).equals(list.get(j))) {
                    list.remove(i);
                    break;
                }
            }
}
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}