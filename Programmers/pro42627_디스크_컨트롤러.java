import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<Job> waitQ = new PriorityQueue<>((Job o1, Job o2) -> Integer.compare(o1.requestTime, o2.requestTime));
        PriorityQueue<Job> workQ = new PriorityQueue<>((Job o1, Job o2) -> Integer.compare(o1.workTime, o2.workTime));
        for (int[] job : jobs) {
            waitQ.add(new Job(job[0], job[1]));
        }
        int timeTotal = 0, jobCount = 0, currentTime = 0;
        while (jobCount < jobs.length) {
            while (!waitQ.isEmpty() && (waitQ.peek().requestTime <= currentTime)) {
                workQ.add(waitQ.poll());
            }
            if (!workQ.isEmpty()) {
                Job job = workQ.poll();
                timeTotal += currentTime - job.requestTime + job.workTime;
                currentTime += job.workTime;
                jobCount++;
            } else {
                currentTime++;
            }
        }
        return timeTotal / jobCount;
    }

    class Job {
        int requestTime, workTime;

        public Job(int requestTime, int workTime) {
            this.requestTime = requestTime;
            this.workTime = workTime;
        }
    }
}