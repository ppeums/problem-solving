import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;

        Arrays.sort(routes, (o1, o2) -> Integer.compare(o2[1], o1[1]));

        int start = -30000;
        int end = 30000;

        for (int[] route : routes) {
            if (route[1] >= start && route[1] <= end) {
                start = Math.max(start, route[0]);
            } else {
                answer++;
                start = route[0];
            }
            end = route[1];
        }

        return answer;
    }
}