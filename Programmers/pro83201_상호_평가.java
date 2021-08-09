class Solution {
    public String solution(int[][] scores) {
        String answer = "";
        int n = scores.length;

        for (int i = 0; i < n; i++) {
            double avg = getAvg(i, n, scores);
            String grade = getGrade(avg);

            answer += grade;
        }

        return answer;
    }

    public double getAvg(int i, int n, int[][] scores) {
        int sum = 0;
        int min = 100;
        int max = 0;

        for (int j = 0; j < n; j++) {
            sum += scores[j][i];
            min = Math.min(min, scores[j][i]);
            max = Math.max(max, scores[j][i]);
        }

        int cnt = 0;

        if (scores[i][i] == min) {
            for (int j = 0; j < n; j++) {
                if (min == scores[j][i]) {
                    cnt++;
                }
            }
        } else if (scores[i][i] == max) {
            for (int j = 0; j < n; j++) {
                if (max == scores[j][i]) {
                    cnt++;
                }
            }
        }

        if (cnt == 1) {
            sum -= scores[i][i];
            n--;
        }

        return (double) sum / n;
    }

    public String getGrade(double avg) {
        switch ((int) avg / 10) {
            case 9:
                return "A";
            case 8:
                return "B";
            case 7:
                return "C";
            case 6:
            case 5:
                return "D";
            default:
                return "F";
        }
    }
}