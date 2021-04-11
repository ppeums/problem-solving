class Solution {
    public String solution(String s) {
        String answer = "";
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            String cur = Character.toString(s.charAt(i));
            if (cur.equals(" ")) {
                answer += " ";
                idx = 0;
            } else if (idx % 2 == 0) {
                answer += cur.toUpperCase();
                idx++;
            } else {
                answer += cur.toLowerCase();
                idx++;
            }
        }
        return answer;
    }
}