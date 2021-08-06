class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int mod = 1000000007;
        int[][] map = new int[n + 1][m + 1];
        boolean[][] isPuddle = new boolean[n + 1][m + 1];

        for (int[] p : puddles) {
            isPuddle[p[1]][p[0]] = true;
        }

        map[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            if (!isPuddle[i][1]) {
                map[i][1] = map[i - 1][1];
            }
        }

        for (int i = 2; i <= m; i++) {
            if (!isPuddle[1][i]) {
                map[1][i] = map[1][i - 1];
            }
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                if (!isPuddle[i][j]) {
                    map[i][j] = (map[i - 1][j] + map[i][j - 1]) % mod;
                }
            }
        }

        return map[n][m];
    }
}