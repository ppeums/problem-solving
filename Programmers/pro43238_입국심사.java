import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = Long.MAX_VALUE, left = 1, right = n * (long) times[times.length - 1];
        while (left <= right) {
            long mid = (left + right) / 2, tmp = 0;
            for (int i = 0; i < times.length; i++) {
                tmp += mid / times[i];
            }
            if (tmp < n) {
                left = mid + 1;
            } else {
                answer = Math.min(answer, mid);
                right = mid - 1;
            }
        }
        return answer;
    }
}