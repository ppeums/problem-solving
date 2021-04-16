import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0, sum = 0;
        Queue<Integer> truck = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < truck_weights.length; i++)
            truck.add(truck_weights[i]);
        for (int i = 0; i < bridge_length; i++)
            bridge.add(0);
        while (true) {
            if (truck.isEmpty() && sum == 0) break;
            answer++;
            int out = bridge.poll();
            sum -= out;
            if (!truck.isEmpty() && sum + truck.peek() <= weight) {
                int in = truck.poll();
                bridge.add(in);
                sum += in;
            } else bridge.add(0);
        }
        return answer;
    }
}