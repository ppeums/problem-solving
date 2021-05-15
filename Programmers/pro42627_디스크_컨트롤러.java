import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        ArrayList<Job> list = new ArrayList<>();
        for (int i = 0; i < jobs.length; i++) {
            list.add(new Job(jobs[i][0], jobs[i][1]));
        }
        Collections.sort(list, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                if (o1.req > o2.req) {
                    return 1;
                } else if (o1.req == o2.req) {
                    if (o1.time > o2.time) {
                        return 1;
                    }
                }
                return -1;
            }
        });
        PriorityQueue<Job> pq = new PriorityQueue<>();
        int answer = 0, now = 0, idx = 0;
        while (idx < jobs.length) {
            Job job = list.get(idx);
            if (job.req <= now) {
                pq.add(job);
                idx++;
            } else {
                if (pq.isEmpty()) {
                    now++;
                } else {
                    Job top = pq.poll();
                    answer += now - top.req + top.time;
                    now += top.time;
                }
            }
        }
        while (!pq.isEmpty()) {
            Job top = pq.poll();
            answer += now - top.req + top.time;
            now += top.time;
        }
        return answer / jobs.length;
    }

    static class Job implements Comparable<Job> {
        int req, time;

        public Job(int req, int time) {
            this.req = req;
            this.time = time;
        }

        @Override
        public int compareTo(Job o) {
            return (time > o.time) ? 1 : -1;
        }
    }
}