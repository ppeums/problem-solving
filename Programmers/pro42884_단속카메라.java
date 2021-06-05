import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        int answer = 0, min = -30001;
        for (int[] route : routes) {
            if (route[0] > min) {
                answer++;
                min = route[1];
            }
        }
        return answer;
    }
}