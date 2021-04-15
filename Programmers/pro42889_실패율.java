import java.util.PriorityQueue;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        PriorityQueue<Stage> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            int cnt = 0, total = 0;
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] == i)
                    cnt++;
                if (stages[j] >= i)
                    total++;
            }
            Stage s = new Stage((cnt == 0) ? 0 : (double) cnt / total, i);
            pq.add(s);
        }
        int size = pq.size();
        for (int i = 0; i < size; i++) {
            int n = pq.peek().n;
            answer[i] = n;
            pq.poll();
        }
        return answer;
    }

    static class Stage implements Comparable<Stage> {
        double fail;
        int n;

        public Stage(double fail, int n) {
            this.fail = fail;
            this.n = n;
        }

        @Override
        public int compareTo(Stage s) {
            if (this.fail < s.fail)
                return 1;
            else if (this.fail == s.fail) {
                if (this.n > s.n)
                    return 1;
                else
                    return -1;
            }
            return -1;
        }
    }
}