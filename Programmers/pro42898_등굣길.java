class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n + 1][m + 1];
        boolean[][] isPuddle = new boolean[n + 1][m + 1];
        for (int[] p : puddles) {
            isPuddle[p[1]][p[0]] = true;
        }
        map[1][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (!isPuddle[i][j]) {
                    if (i > 1) {
                        map[i][j] += map[i - 1][j];
                    }
                    if (j > 1) {
                        map[i][j] += map[i][j - 1];
                    }
                    map[i][j] %= 1000000007;
                }
            }
        }
        return map[n][m];
    }
}