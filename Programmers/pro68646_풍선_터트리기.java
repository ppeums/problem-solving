class Solution {
    public int solution(int[] a) {
        int answer = 2;
        int[] leftMin = new int[a.length];
        int[] rightMin = new int[a.length];
        int min = a[0];
        for (int i = 1; i < a.length - 1; i++) {
            leftMin[i] = min;
            min = Math.min(min, a[i]);
        }
        min = a[a.length - 1];
        for (int i = a.length - 2; i > 0; i--) {
            rightMin[i] = min;
            min = Math.min(min, a[i]);
        }
        for (int i = 1; i < a.length - 1; i++) {
            if (a[i] <= leftMin[i] || a[i] <= rightMin[i]) {
                answer++;
            }
        }
        return answer;
    }
}