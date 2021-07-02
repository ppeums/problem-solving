import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] cmd = commands[i];
            int[] tmp = new int[cmd[1] - cmd[0] + 1];
            int idx = 0;
            for (int j = cmd[0] - 1; j < cmd[1]; j++) {
                tmp[idx++] = array[j];
            }
            Arrays.sort(tmp);
            answer[i] = tmp[cmd[2] - 1];
        }
        return answer;
    }
}