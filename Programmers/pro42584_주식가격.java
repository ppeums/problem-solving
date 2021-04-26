import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!st.isEmpty() && prices[st.peek()] > prices[i]) {
                int top = st.pop();
                answer[top] = i - top;
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            int top = st.pop();
            answer[top] = prices.length - 1 - top;
        }
        return answer;
    }
}