class Solution {
    int[] col;
    int answer;

    public int solution(int n) {
        col = new int[n];
        for (int i = 0; i < n; i++) {
            col[0] = i;
            queen(n, 1);
        }
        return answer;
    }

    public void queen(int n, int row) {
        if (row == n) {
            answer++;
            return;
        }
        for (int i = 0; i < n; i++) {
            col[row] = i;
            if (isPossible(row)) {
                queen(n, row + 1);
            }
        }
    }

    public boolean isPossible(int row) {
        for (int i = 0; i < row; i++) {
            if (col[i] == col[row]) {
                return false;
            }
            if (Math.abs(i - row) == Math.abs(col[i] - col[row])) {
                return false;
            }
        }
        return true;
    }
}