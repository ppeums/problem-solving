class Solution {
    static int[] input;
    static int key, answer = 0;

    public int solution(int[] numbers, int target) {
        input = numbers;
        key = target;
        DFS(0, 0);
        return answer;
    }

    static void DFS(int start, int sum) {
        if (start == input.length) {
            if (sum == key)
                answer++;
            return;
        }
        DFS(start + 1, sum + input[start]);
        DFS(start + 1, sum - input[start]);
    }
}