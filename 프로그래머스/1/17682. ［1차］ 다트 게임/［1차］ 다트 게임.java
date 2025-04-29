class Solution {
    public int solution(String dartResult) {
        int[] scores = new int[3];
        int idx = 0;
        int length = dartResult.length();
        int i = 0;

        while (i < length) {
            int score = 0;

            if (i + 1 < length && dartResult.charAt(i) == '1' && dartResult.charAt(i + 1) == '0') {
                score = 10;
                i += 2;
            } else {
                score = dartResult.charAt(i) - '0';
                i++;
            }

            char bonus = dartResult.charAt(i);
            if (bonus == 'S') {
                score = (int) Math.pow(score, 1);
            } else if (bonus == 'D') {
                score = (int) Math.pow(score, 2);
            } else if (bonus == 'T') {
                score = (int) Math.pow(score, 3);
            }
            i++;

            if (i < length) {
                char option = dartResult.charAt(i);
                if (option == '*') {
                    score *= 2;
                    if (idx > 0) {
                        scores[idx - 1] *= 2;
                    }
                    i++;
                } else if (option == '#') {
                    score *= -1;
                    i++;
                }
            }

            scores[idx++] = score;
        }

        int answer = 0;
        for (int s : scores) {
            answer += s;
        }
        return answer;
    }
}
