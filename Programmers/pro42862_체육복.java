import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] clothes = new int[n + 2];
        Arrays.fill(clothes, 1);
        for (int re : reserve) {
            clothes[re]++;
        }
        for (int lo : lost) {
            clothes[lo]--;
        }
        for (int i = 1; i <= n; i++) {
            if (clothes[i] > 0) {
                answer++;
            } else {
                if (clothes[i - 1] > 1) {
                    clothes[i - 1]--;
                    answer++;
                } else if (clothes[i + 1] > 1) {
                    clothes[i + 1]--;
                    answer++;
                }
            }
        }
        return answer;
    }
}