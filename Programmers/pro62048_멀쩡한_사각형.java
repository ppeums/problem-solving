import java.math.BigInteger;

class Solution {
    public long solution(int w, int h) {
        BigInteger b1 = BigInteger.valueOf(w);
        BigInteger b2 = BigInteger.valueOf(h);
        long gcd = b1.gcd(b2).longValue();
        return ((long) w * (long) h) - (w + h - gcd);
    }
}