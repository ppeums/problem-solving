import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++)
            q.add(0);
        int sum = 0, idx = 0;
        while (true) {
            answer++;
            sum -= q.poll();
            if (idx == truck_weights.length && sum == 0)
                break;
            if (idx < truck_weights.length && sum + truck_weights[idx] <= weight) {
                q.add(truck_weights[idx]);
                sum += truck_weights[idx++];
            } else q.add(0);
        }
        return answer;
    }
}