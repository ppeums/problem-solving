class Solution {
    public String solution(int n) {
        String answer = "";
        String[] arr = {"4", "1", "2"};
        while (n > 0) {
            int idx = n % 3;
            answer = arr[idx] + answer;
            n /= 3;
            if (idx == 0) n--;
        }
        return answer;
    }
}