import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville)
            pq.add(i);
        while (true) {
            if (pq.peek() >= K) break;
            if (pq.size() < 2) return -1;
            int first = pq.poll();
            int second = pq.poll();
            pq.add(first + second * 2);
            answer++;
        }
        return answer;
    }
}