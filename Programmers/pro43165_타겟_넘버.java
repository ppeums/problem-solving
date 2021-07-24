class Solution {
    int[] input;
    int answer;

    public int solution(int[] numbers, int target) {
        input = numbers;
        findTarget(0, 0, target);
        return answer;
    }

    public void findTarget(int cnt, int sum, int target) {
        if (cnt == input.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        findTarget(cnt + 1, sum + input[cnt], target);
        findTarget(cnt + 1, sum - input[cnt], target);
    }
}