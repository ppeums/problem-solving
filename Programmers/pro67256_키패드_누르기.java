class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[][] point = {{3, 1}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}};
        int[] left = {3, 0};
        int[] right = {3, 2};
        for (int i = 0; i < numbers.length; i++) {
            int[] next = {point[numbers[i]][0], point[numbers[i]][1]};
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                left = next;
                answer += "L";
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                right = next;
                answer += "R";
            } else {
                int ldist = Math.abs(left[0] - next[0]) + Math.abs(left[1] - next[1]);
                int rdist = Math.abs(right[0] - next[0]) + Math.abs(right[1] - next[1]);
                if (ldist < rdist) {
                    left = next;
                    answer += "L";
                } else if (ldist > rdist) {
                    right = next;
                    answer += "R";
                } else {
                    if (hand.equals("left")) {
                        left = next;
                        answer += "L";
                    } else {
                        right = next;
                        answer += "R";
                    }
                }
            }
        }
        return answer;
    }
}