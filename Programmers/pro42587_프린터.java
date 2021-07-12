import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Document> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
            q.add(new Document(i, priorities[i]));
        }
        int answer = 0;
        while (true) {
            Document now = q.poll();
            int id = now.id;
            int priority = now.priority;
            if (pq.peek() == priority) {
                pq.poll();
                answer++;
                if (id == location) {
                    break;
                }
            } else {
                q.add(now);
            }
        }
        return answer;
    }

    class Document {
        int id, priority;

        public Document(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }
}