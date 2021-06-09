class Solution {
    public int solution(int n, int[] money) {
        int[][] d = new int[money.length + 1][n + 1];
        for (int i = 1; i <= money.length; i++) {
            for (int j = 0; j <= n; j++) {
                if (j == 0) {
                    d[i][j] = 1;
                } else {
                    d[i][j] = d[i - 1][j];
                    if (j - money[i - 1] >= 0) {
                        d[i][j] += d[i][j - money[i - 1]];
                    }
                }
            }
        }
        return d[money.length][n];
    }
}