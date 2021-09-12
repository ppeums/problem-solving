import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        int[] arr = new int[n];
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr[i] = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
        }

        int cnt = 1;
        int max = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                answer.add(cnt);
                cnt = 1;
                max = arr[i];
            } else {
                cnt++;
            }
        }

        answer.add(cnt);

        return answer.stream().mapToInt(i -> i).toArray();
    }
}