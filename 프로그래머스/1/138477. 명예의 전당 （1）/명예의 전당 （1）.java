import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[] result = new int[score.length];

        for (int i = 0; i < score.length; i++) {
            minHeap.offer(score[i]);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
            result[i] = minHeap.peek();
        }

        return result;
    }
}
