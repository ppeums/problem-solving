import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int len = progresses.length;
        int[] day = new int[len];
        int idx = 0, max = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            day[i] = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            if (i == 0) {
                arr.add(1);
                max = day[0];
            } else {
                if (day[i - 1] >= day[i])
                    arr.set(idx, arr.get(idx) + 1);
                else {
                    if (max >= day[i])
                        arr.set(idx, arr.get(idx) + 1);
                    else {
                        idx++;
                        arr.add(1);
                        max = day[i];
                    }
                }
            }
        }
        int[] answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++)
            answer[i] = arr.get(i);
        return answer;
    }
}