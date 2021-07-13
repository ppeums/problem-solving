import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] clothes = new int[n + 1];
        Arrays.fill(clothes, 1, n + 1, 1);
        for (int l : lost) {
            clothes[l]--;
        }
        for (int r : reserve) {
            clothes[r]++;
        }
        for (int i = 1; i <= n; i++) {
            if (clothes[i] == 0) {
                if (clothes[i - 1] > 1) {
                    clothes[i]++;
                    clothes[i - 1]--;
                } else if (i < n && clothes[i + 1] > 1) {
                    clothes[i]++;
                    clothes[i + 1]--;
                }
            }
        }
        for (int c : clothes) {
            if (c > 0) {
                answer++;
            }
        }
        return answer;
    }
}