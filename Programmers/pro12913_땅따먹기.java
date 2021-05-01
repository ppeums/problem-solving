class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int N = land.length;
        int[][] d = new int[N][4];
        for (int i = 0; i < 4; i++)
            d[0][i] = land[0][i];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (j != k)
                        d[i][j] = Math.max(d[i][j], d[i - 1][k]);
                }
                d[i][j] += land[i][j];
                answer = Math.max(answer, d[i][j]);
            }
        }
        return answer;
    }
}