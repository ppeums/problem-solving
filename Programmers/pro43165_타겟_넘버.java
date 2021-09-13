class Solution {
    int[] input;
    int answer;

    public int solution(int[] numbers, int target) {
        input = numbers;

        dfs(0, 0, numbers.length, target);

        return answer;
    }

    public void dfs(int idx, int sum, int n, int target) {
        if (idx == n) {
            if (sum == target) {
                answer++;
            }

            return;
        }

        dfs(idx + 1, sum - input[idx], n, target);
        dfs(idx + 1, sum + input[idx], n, target);
    }
}