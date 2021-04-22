import java.util.Stack;

class Solution {
    public int solution(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!st.isEmpty() && ch == st.peek())
                st.pop();
            else
                st.push(ch);
        }
        if (st.isEmpty()) return 1;
        return 0;
    }
}