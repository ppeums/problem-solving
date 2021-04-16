import java.math.BigInteger;

class Solution {
    public long solution(int w, int h) {
        long gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).longValue();
        long answer = ((long) w * (long) h) - ((long) w + (long) h - gcd);
        return answer;
    }
}