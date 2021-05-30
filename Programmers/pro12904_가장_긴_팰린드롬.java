class Solution {
    public int solution(String s) {
        for (int i = s.length(); i > 0; i--) {
            for (int j = 0; j <= s.length() - i; j++) {
                boolean isAnswer = true;
                for (int k = j; k < j + (i / 2); k++) {
                    if (s.charAt(k) != s.charAt(2 * j + i - 1 - k)) {
                        isAnswer = false;
                        break;
                    }
                }
                if (isAnswer) {
                    return i;
                }
            }
        }
        return 0;
    }
}