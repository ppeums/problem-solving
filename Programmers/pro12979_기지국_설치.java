class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int i = 1, j = 0, max = w * 2 + 1;
        while (i <= n) {
            if (j < stations.length && i >= stations[j] - w && i <= stations[j] + w) {
                i = stations[j] + w + 1;
                j++;
            } else {
                answer++;
                i += max;
            }
        }
        return answer;
    }
}