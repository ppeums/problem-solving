import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        int answer = 0, min = -30001;
        for (int[] route : routes) {
            if (min < route[0]) {
                answer++;
                min = route[1];
            }
        }
        return answer;
    }
}