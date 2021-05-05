import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for (int i = citations[citations.length - 1]; i >= 0; i--) {
            int cnt = 0;
            for (int j = 0; j < citations.length; j++) {
                if (citations[j] >= i)
                    cnt++;
            }
            if (cnt >= i) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}