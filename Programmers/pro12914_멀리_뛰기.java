class Solution {
    public long solution(int n) {
        long[] d = new long[2001];
        int mod = 1234567;
        d[1] = 1;
        d[2] = 2;
        for (int i = 3; i <= n; i++) {
            d[i] = (d[i - 1] + d[i - 2]) % mod;
        }
        return d[n];
    }
}