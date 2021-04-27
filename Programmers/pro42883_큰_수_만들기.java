import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int len = number.length() - k;
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);
            if (!st.isEmpty() && st.peek() < ch && k > 0) {
                while (true) {
                    if (st.isEmpty() || st.peek() >= ch || k == 0) break;
                    st.pop();
                    k--;
                }
            }
            st.add(ch);
        }
        while (!st.isEmpty())
            answer = st.pop() + answer;
        return answer.substring(0, len);
    }
}