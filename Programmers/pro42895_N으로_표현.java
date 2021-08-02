class Solution {
    int answer;

    public int solution(int N, int number) {
        answer = Integer.MAX_VALUE;

        func(N, number, 0, 0);

        return (answer == Integer.MAX_VALUE) ? -1 : answer;
    }

    public void func(int N, int number, int cnt, int prev) {
        if (cnt > 8) {
            return;
        }

        if (prev == number) {
            answer = Math.min(answer, cnt);
            return;
        }

        int tmp = N;

        for (int i = 0; i < 8 - cnt; i++) {
            int nextCnt = cnt + 1 + i;

            func(N, number, nextCnt, prev + tmp);
            func(N, number, nextCnt, prev - tmp);
            func(N, number, nextCnt, prev * tmp);
            func(N, number, nextCnt, prev / tmp);

            tmp = tmp * 10 + N;
        }
    }
}