import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> st = new Stack<>();
        st.add(0);
        for (int i = 1; i < prices.length; i++) {
            while (!st.isEmpty() && prices[st.peek()] > prices[i]) {
                int top = st.pop();
                answer[top] = i - top;
            }
            st.add(i);
        }
        while (!st.isEmpty()) {
            int top = st.pop();
            answer[top] = answer.length - 1 - top;
        }
        return answer;
    }
}