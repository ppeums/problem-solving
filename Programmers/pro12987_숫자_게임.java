import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int max = B.length - 1, min = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] < B[max]) {
                answer++;
                max--;
            } else if (A[i] < B[min]) {
                answer++;
                min++;
            }
        }
        return answer;
    }
}