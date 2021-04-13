import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] stu = new int[n + 1];
        Arrays.fill(stu, 1);
        for (int i = 0; i < lost.length; i++) {
            stu[lost[i]]--;
        }
        for (int i = 0; i < reserve.length; i++) {
            stu[reserve[i]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (stu[i] == 2) {
                if (i - 1 >= 1 && stu[i - 1] == 0) {
                    stu[i - 1]++;
                    stu[i]--;
                } else if (i + 1 <= n && stu[i + 1] == 0) {
                    stu[i + 1]++;
                    stu[i]--;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (stu[i] > 0) {
                answer++;
            }
        }
        return answer;
    }
}