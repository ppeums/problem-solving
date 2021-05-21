import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (String operation : operations) {
            char op = operation.charAt(0);
            int num = Integer.parseInt(operation.substring(2));
            if (op == 'I') {
                maxHeap.add(num);
                minHeap.add(num);
            } else if (!maxHeap.isEmpty()) {
                if (num == 1) {
                    int max = maxHeap.poll();
                    minHeap.remove(max);
                } else {
                    int min = minHeap.poll();
                    maxHeap.remove(min);
                }
            }
        }
        return (maxHeap.isEmpty()) ? new int[]{0, 0} : new int[]{maxHeap.poll(), minHeap.poll()};
    }
}