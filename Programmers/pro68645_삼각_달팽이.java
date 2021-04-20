class Solution {
    public int[] solution(int n) {
        int len = 0;
        for (int i = 1; i <= n; i++)
            len += i;
        int[] answer = new int[len];
        int[][] arr = new int[n][n];
        int x = 0, y = 0, num = 1;
        while (true) {
            if (num > len) break;
            while (true) {
                if (y < 0 || y >= n || x < 0 || x >= n || arr[y][x] != 0) {
                    y--;
                    x++;
                    break;
                }
                arr[y][x] = num++;
                y++;
            }
            while (true) {
                if (y < 0 || y >= n || x < 0 || x >= n || arr[y][x] != 0) {
                    y--;
                    x -= 2;
                    break;
                }
                arr[y][x] = num++;
                x++;
            }
            while (true) {
                if (y < 0 || y >= n || x < 0 || x >= n || arr[y][x] != 0) {
                    y += 2;
                    x++;
                    break;
                }
                arr[y][x] = num++;
                y--;
                x--;
            }
        }
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != 0)
                    answer[idx++] = arr[i][j];
                else break;
            }
        }
        return answer;
    }
}