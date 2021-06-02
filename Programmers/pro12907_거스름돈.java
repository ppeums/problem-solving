class Solution {
    public int solution(int n, int[] money) {
        int[][] d = new int[money.length + 1][n + 1];
        int mod = 1000000007;
        for (int i = 1; i <= money.length; i++) {
            for (int j = 0; j <= n; j++) {
                if (j == 0) {
                    d[i][j] = 1;
                } else {
                    if (j - money[i - 1] >= 0) {
                        d[i][j] = d[i - 1][j] + d[i][j - money[i - 1]];
                    } else {
                        d[i][j] = d[i - 1][j];
                    }
                    d[i][j] %= mod;
                }
            }
        }
        return d[money.length][n];
    }
}