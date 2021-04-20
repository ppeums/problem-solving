class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);
        int i = 1;
        while (true) {
            if (k <= 0 || i >= sb.length()) break;
            if (sb.charAt(i - 1) < sb.charAt(i)) {
                sb.deleteCharAt(i - 1);
                k--;
                if (i > 1) i--;
            } else i++;
        }
        if (k > 0)
            sb.delete(sb.length() - k, sb.length());
        return sb.toString();
    }
}