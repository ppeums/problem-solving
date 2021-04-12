class Solution {
    public int[] solution(int[] answers) {
        int[][] p = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int[] sum = new int[3];
        int[] idx = new int[3];
        int[] lim = {5, 8, 10};
        int max = 0, cnt = 0;
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (answers[i] == p[j][idx[j]++]) {
                    sum[j]++;
                    max = Math.max(max, sum[j]);
                }
                if (idx[j] == lim[j])
                    idx[j] = 0;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (max == sum[i])
                cnt++;
        }
        int[] answer = new int[cnt];
        int j = 0;
        for (int i = 0; i < 3; i++) {
            if (max == sum[i])
                answer[j++] = i + 1;
        }
        return answer;
    }
}