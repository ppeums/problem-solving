import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < works.length; i++) {
            pq.add(works[i]);
        }
        for (int i = 0; i < n; i++) {
            if (pq.peek() == 0) {
                break;
            }
            int front = pq.poll();
            pq.add(front - 1);
        }
        for (int i = 0; i < works.length; i++) {
            int front = pq.poll();
            answer += front * front;
        }
        return answer;
    }
}