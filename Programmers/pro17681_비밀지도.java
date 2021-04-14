class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            String str = Integer.toString(arr1[i] | arr2[i], 2);
            str = str.replace('1', '#');
            str = str.replace('0', ' ');
            while (str.length() != n) {
                str = ' ' + str;
            }
            answer[i] = str;
        }
        return answer;
    }
}