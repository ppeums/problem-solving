class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int sum = s, cnt = n;
        if (s / n == 0) {
            return new int[]{-1};
        }
        for (int i = 0; i < n; i++) {
            answer[i] = sum / cnt;
            sum -= sum / (cnt--);
        }
        return answer;
    }
}