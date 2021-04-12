class Solution {
    public int solution(int n) {
        int answer = 0;
        String s = "";
        while (n != 0) {
            s += Integer.toString(n % 3);
            n /= 3;
        }
        StringBuilder sb = new StringBuilder(s);
        s = sb.reverse().toString();
        int exp = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - '0';
            answer += cur * Math.pow(3, exp++);
        }
        return answer;
    }
}