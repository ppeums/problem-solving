class Solution {
    public int[] solution(int n) {
        int len = n * (n + 1) / 2, num = 1, y = 0, x = 0;
        int[][] arr = new int[n][n];
        int[] answer = new int[len];
        while (true) {
            if (num > len) break;
            for (int i = 0; i < n; i++) {
                arr[y++][x] = num++;
            }
            n--; y--; x++;
            for (int i = 0; i < n; i++) {
                arr[y][x++] = num++;
            }
            n--; y--; x -= 2;
            for (int i = 0; i < n; i++) {
                arr[y--][x--] = num++;
            }
            n--; x++; y += 2;
        }
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] > 0)
                    answer[idx++] = arr[i][j];
            }
        }
        return answer;
    }
}