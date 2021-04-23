class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int half = (brown - 4) / 2;
        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0 && i + (yellow / i) == half) {
                answer[0] = yellow / i + 2;
                answer[1] = i + 2;
                break;
            }
        }
        return answer;
    }
}