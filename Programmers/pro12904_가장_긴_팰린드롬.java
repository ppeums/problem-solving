class Solution {
    public int solution(String s) {
        for (int i = s.length(); i > 1; i--) {
            for (int j = 0; j <= s.length() - i; j++) {
                boolean isAnswer = true;
                for (int k = 0; k < i / 2; k++) {
                    if (s.charAt(j + k) != s.charAt(j + i - 1 - k)) {
                        isAnswer = false;
                        break;
                    }
                }
                if (isAnswer) {
                    return i;
                }
            }
        }
        return 1;
    }
}