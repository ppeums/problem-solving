class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder(number);
        int idx = 0;
        while (true) {
            if (k == 0 || idx >= answer.length() - 1) {
                break;
            }
            if (answer.charAt(idx) < answer.charAt(idx + 1)) {
                answer = answer.deleteCharAt(idx);
                k--;
                if (idx > 0) {
                    idx--;
                }
            } else {
                idx++;
            }
        }
        if (k > 0) {
            answer.setLength(answer.length() - k);
        }
        return answer.toString();
    }
}