import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                st.push(ch);
            else {
                if (st.isEmpty()) return false;
                if (st.peek() == '(')
                    st.pop();
            }
        }
        if (!st.isEmpty()) return false;
        return true;
    }
}