import java.math.BigInteger;

class Solution {
    public int solution(int[] arr) {
        BigInteger b1 = BigInteger.valueOf(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            BigInteger b2 = BigInteger.valueOf(arr[i]);
            BigInteger gcd = b1.gcd(b2);
            b1 = b1.multiply(b2).divide(gcd);
        }
        return b1.intValue();
    }
}