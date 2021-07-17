import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> truck = new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int t : truck_weights) {
            truck.add(t);
        }
        for (int i = 0; i < bridge_length; i++) {
            q.add(0);
        }
        int current = 0;
        while (true) {
            answer++;
            current -= q.poll();
            if (truck.isEmpty() && current == 0) {
                break;
            }
            if (!truck.isEmpty()) {
                int peek = truck.peek();
                if (peek <= weight - current) {
                    q.add(peek);
                    current += truck.poll();
                } else {
                    q.add(0);
                }
            }
        }
        return answer;
    }
}