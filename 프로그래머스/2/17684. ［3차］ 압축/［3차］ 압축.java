import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> output = new ArrayList<>();
        Map<String, Integer> dictionary = new HashMap<>();
        
        int dictSize = 1;
        for (char c = 'A'; c <= 'Z'; c++) {
            dictionary.put(String.valueOf(c), dictSize++);
        }
        
        String w = "";
        for (char c : msg.toCharArray()) {
            String wc = w + c;
            if (dictionary.containsKey(wc)) {
                w = wc;
            } else {
                output.add(dictionary.get(w));
                dictionary.put(wc, dictSize++);
                w = String.valueOf(c);
            }
        }
        
        if (!w.isEmpty()) {
            output.add(dictionary.get(w));
        }
        
        int[] result = new int[output.size()];
        for (int i = 0; i < output.size(); i++) {
            result[i] = output.get(i);
        }

        return result;
    }
}
