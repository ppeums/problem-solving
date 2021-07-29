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
                minHeap.add(num);
                maxHeap.add(num);
            } else {
                if (num == 1) {
                    if (!maxHeap.isEmpty()) {
                        if (maxHeap.peek() >= minHeap.peek()) {
                            maxHeap.poll();
                        }
                    }
                } else {
                    if (!minHeap.isEmpty()) {
                        if (maxHeap.peek() >= minHeap.peek()) {
                            minHeap.poll();
                        }
                    }
                }
            }

            if (!minHeap.isEmpty() && !maxHeap.isEmpty() && (minHeap.peek() > maxHeap.peek())) {
                maxHeap.clear();
                minHeap.clear();
            }
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        while (!minHeap.isEmpty() && !maxHeap.isEmpty() && (minHeap.peek() <= maxHeap.peek())) {
            max = Math.max(max, maxHeap.poll());
            min = Math.min(min, minHeap.poll());
        }

        if ((max == Integer.MIN_VALUE) && (min == Integer.MAX_VALUE)) {
            max = 0;
            min = 0;
        }

        return new int[]{max, min};
    }
}