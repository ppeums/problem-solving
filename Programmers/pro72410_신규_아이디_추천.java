class Solution {
    public String solution(String new_id) {
        String answer = "";
        String tmp = "";
        new_id = new_id.toLowerCase();
        for (int i = 0; i < new_id.length(); i++) {
            char ch = new_id.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9') || ch == '-' || ch == '_' || ch == '.')
                tmp += ch;
        }
        for (int i = 0; i < tmp.length(); i++) {
            char ch = tmp.charAt(i);
            if (ch == '.') {
                if (i == 0) {
                    answer += ch;
                    continue;
                }
                char before = tmp.charAt(i - 1);
                if (before != '.')
                    answer += ch;
            } else {
                answer += ch;
            }
        }
        if (answer.startsWith("."))
            answer = answer.substring(1, answer.length());
        if (answer.endsWith("."))
            answer = answer.substring(0, answer.length() - 1);
        if (answer.length() == 0)
            answer = "a";
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            if (answer.endsWith("."))
                answer = answer.substring(0, answer.length() - 1);
        }
        if (answer.length() > 0 && answer.length() <= 2) {
            while (answer.length() != 3)
                answer += answer.charAt(answer.length() - 1);
        }
        return answer;
    }
}