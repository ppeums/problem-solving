class Solution {
    public int solution(int n) {
        int[][] d = new int[n + 1][3];
        int mod = 1000000007;
        d[1][1] = 1;
        d[2][1] = 1;
        d[2][2] = 1;
        for (int i = 3; i <= n; i++) {
            d[i][1] = (d[i - 1][1] + d[i - 1][2]) % mod;
            d[i][2] = (d[i - 2][1] + d[i - 2][2]) % mod;
        }
        return (d[n][1] + d[n][2]) % mod;
    }
}