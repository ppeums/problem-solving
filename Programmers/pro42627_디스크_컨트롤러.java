import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int currentTime = 0;

        PriorityQueue<Job> waitQ = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.requestTime, o2.requestTime));
        PriorityQueue<Job> workQ = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.workTime, o2.workTime));

        for (int[] job : jobs) {
            waitQ.add(new Job(job[0], job[1]));
        }

        while (true) {
            if (waitQ.isEmpty() && workQ.isEmpty()) {
                break;
            }

            while (!waitQ.isEmpty() && (waitQ.peek().requestTime <= currentTime)) {
                workQ.add(waitQ.poll());
            }

            if (!workQ.isEmpty()) {
                Job job = workQ.poll();
                currentTime += job.workTime;
                answer += currentTime - job.requestTime;
            } else {
                currentTime++;
            }
        }

        return answer / jobs.length;
    }

    class Job {
        int requestTime, workTime;

        public Job(int requestTime, int workTime) {
            this.requestTime = requestTime;
            this.workTime = workTime;
        }
    }
}