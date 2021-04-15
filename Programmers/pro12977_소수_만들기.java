class Solution {
    static int answer;
    static int[] input;
    static int[] arr = new int[3];
    static boolean[] visit;

    public int solution(int[] nums) {
        input = nums;
        visit = new boolean[nums.length];
        DFS(0, 0);
        return answer;
    }

    static void DFS(int cnt, int start) {
        if (cnt == 3) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++)
                sum += input[arr[i]];
            for (int i = 2; i <= sum / 2; i++)
                if (sum % i == 0)
                    return;
            answer++;
            return;
        }
        for (int i = start; i < input.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[cnt] = i;
                DFS(cnt + 1, i + 1);
                visit[i] = false;
            }
        }
    }
}