import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        for (int i = 1; i < prices.length; i++) {
            while (true) {
                if (stack.isEmpty() || prices[stack.peek()] <= prices[i]) break;
                int top = stack.pop();
                answer[top] = i - top;
            }
            stack.add(i);
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            answer[top] = prices.length - 1 - top;
        }
        return answer;
    }
}