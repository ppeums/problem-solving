class Solution {
    public int solution(String dirs) {
        boolean[][][][] visit = new boolean[11][11][11][11];
        int y = 5, x = 5, answer = 0;
        for (int i = 0; i < dirs.length(); i++) {
            char ch = dirs.charAt(i);
            int ny = y, nx = x;
            if (ch == 'U' && y > 0)
                ny = y - 1;
            if (ch == 'D' && y < 10)
                ny = y + 1;
            if (ch == 'R' && x < 10)
                nx = x + 1;
            if (ch == 'L' && x > 0)
                nx = x - 1;
            if (!visit[y][x][ny][nx] && (y != ny || x != nx)) {
                visit[y][x][ny][nx] = visit[ny][nx][y][x] = true;
                answer++;
            }
            y = ny; x = nx;
        }
        return answer;
    }
}