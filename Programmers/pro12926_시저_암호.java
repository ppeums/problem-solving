class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if (now == ' ') {
                answer += " ";
            } else {
                char code = (char) ((int) now + n);
                if (now >= 'a' && now <= 'z') {
                    if (code > 'z') {
                        code = (char)(code - 'z' + 'a' - 1);
                    }

                } else {
                    if (code > 'Z') {
                        code = (char)(code - 'Z' + 'A' - 1);
                    }
                }
                answer += Character.toString(code);
            }
        }
        return answer;
    }
}