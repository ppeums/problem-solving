class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] result = {6, 6, 5, 4, 3, 2, 1};
        int empty = 0, cnt = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) empty++;
            else {
                for (int j = 0; j < win_nums.length; j++) {
                    if (lottos[i] == win_nums[j]) {
                        cnt++;
                        break;
                    }
                }
            }
        }
        return new int[]{result[cnt + empty], result[cnt]};
    }
}