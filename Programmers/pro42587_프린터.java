import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Doc> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            q.add(new Doc(i, priorities[i]));
            pq.add(priorities[i]);
        }
        while (true) {
            if (q.peek().priority == pq.peek()) {
                answer++;
                if (q.peek().id == location) break;
                q.poll();
                pq.poll();
            } else {
                Doc tmp = q.poll();
                q.add(tmp);
            }
        }
        return answer;
    }

    class Doc {
        int id, priority;

        Doc(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }
}