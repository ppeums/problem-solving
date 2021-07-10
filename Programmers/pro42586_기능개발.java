import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int[] day = new int[progresses.length];
        int max = 0, cnt = 0;
        for (int i = 0; i < progresses.length; i++) {
            day[i] = (int) Math.ceil((double) (100 - progresses[i]) / (double) speeds[i]);
            if (i == 0) {
                max = day[0];
                cnt++;
            } else {
                if (day[i] > max) {
                    answer.add(cnt);
                    max = day[i];
                    cnt = 1;
                } else {
                    cnt++;
                }
            }
        }
        answer.add(cnt);
        return answer.stream().mapToInt(i -> i).toArray();
    }
}