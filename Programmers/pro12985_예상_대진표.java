class Solution {
    public int solution(int n, int a, int b) {
        int answer = 1;
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        while (true) {
            if (b % 2 == 0 && a == b - 1) break;
            a = (int) Math.ceil((double) a / 2);
            b = (int) Math.ceil((double) b / 2);
            answer++;
        }
        return answer;
    }
}