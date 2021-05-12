class Solution {
    static int[][] map;
    static int[] answer;

    public int[] solution(int[][] arr) {
        answer = new int[2];
        map = arr;
        func(0, 0, arr.length);
        return answer;
    }

    static void func(int y, int x, int n) {
        boolean isSame = true;
        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++) {
                if (map[i][j] != map[y][x]) {
                    isSame = false;
                    break;
                }
            }
            if (!isSame) {
                break;
            }
        }
        if (isSame) {
            answer[map[y][x]]++;
        } else {
            n /= 2;
            func(y, x, n);
            func(y, x + n, n);
            func(y + n, x, n);
            func(y + n, x + n, n);
        }
    }
}