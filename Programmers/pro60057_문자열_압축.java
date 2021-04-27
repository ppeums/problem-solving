class Solution {
    public int solution(String s) {
        int answer = s.length();
        for (int i = 1; i <= s.length(); i++) {
            String str = "", before = s.substring(0, i);
            int cnt = 1, len = s.length() - s.length() % i;
            for (int j = i; j < len; j += i) {
                String now = s.substring(j, j + i);
                if (before.equals(now)) {
                    cnt++;
                } else {
                    if (cnt > 1)
                        str += Integer.toString(cnt) + before;
                    else
                        str += before;
                    before = now;
                    cnt = 1;
                }
            }
            if (cnt > 1)
                str += Integer.toString(cnt) + before;
            else
                str += before;
            if (len > 0)
                str += s.substring(len, s.length());
            answer = Math.min(answer, str.length());
        }
        return answer;
    }
}