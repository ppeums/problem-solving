class Solution {
    public String solution(String s) {
        String answer = "";
        boolean isFirst = true;
        for (int i = 0; i < s.length(); i++) {
            String cur = Character.toString(s.charAt(i));
            if (cur.equals(" ")) {
                answer += cur;
                isFirst = true;
            } else {
                if (isFirst) {
                    answer += cur.toUpperCase();
                    isFirst = false;
                } else {
                    answer += cur.toLowerCase();
                }
            }
        }
        return answer;
    }
}