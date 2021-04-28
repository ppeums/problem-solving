import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for (int i = citations[citations.length - 1]; i >= 0; i--) {
            answer = 0;
            for (int j = citations.length - 1; j >= 0; j--) {
                if (citations[j] >= i)
                    answer++;
            }
            if (answer >= i) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}