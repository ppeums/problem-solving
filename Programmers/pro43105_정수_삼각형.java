class Solution {
    public int solution(int[][] triangle) {
        int answer = 0, N = triangle.length;
        int[][] d = new int[N][N];
        d[0][0] = triangle[0][0];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    d[i][j] = d[i - 1][j];
                } else if (j == i) {
                    d[i][j] = d[i - 1][j - 1];
                } else {
                    d[i][j] = Math.max(d[i - 1][j], d[i - 1][j - 1]);
                }
                d[i][j] += triangle[i][j];
            }
        }
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, d[N - 1][i]);
        }
        return answer;
    }
}