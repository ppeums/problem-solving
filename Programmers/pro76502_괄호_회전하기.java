import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0, len = s.length();
        for (int i = 0; i < len; i++) {
            Stack<Character> st = new Stack<>();
            boolean isAnswer = true;
            for (int j = 0; j < len; j++) {
                char ch = s.charAt(j);
                if (ch == '[') st.add('[');
                else if (ch == '{') st.add('{');
                else if (ch == '(') st.add('(');
                else if (ch == ']') {
                    if (st.isEmpty() || st.peek() == '(' || st.peek() == '{') {
                        isAnswer = false;
                        break;
                    }
                    if (st.peek() == '[') st.pop();
                } else if (ch == '}') {
                    if (st.isEmpty() || st.peek() == '(' || st.peek() == '[') {
                        isAnswer = false;
                        break;
                    }
                    if (st.peek() == '{') st.pop();
                } else {
                    if (st.isEmpty() || st.peek() == '{' || st.peek() == '[') {
                        isAnswer = false;
                        break;
                    }
                    if (st.peek() == '(') st.pop();
                }
            }
            if (isAnswer && st.isEmpty()) answer++;
            s = s.substring(1, s.length()) + s.substring(0, 1);
        }
        return answer;
    }
}