import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visit;
    static int N, M, answer;
    static boolean isPossible;

    public int solution(int[][] maps) {
        answer = Integer.MAX_VALUE;
        isPossible = false;
        map = maps;
        N = maps.length;
        M = maps[0].length;
        visit = new boolean[N][M];
        BFS();
        if (isPossible) return answer;
        else return -1;
    }

    static void BFS() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 1));
        visit[0][0] = true;
        while (!q.isEmpty()) {
            int y = q.peek().y;
            int x = q.peek().x;
            int cnt = q.peek().cnt;
            q.poll();
            if (y == N - 1 && x == M - 1) {
                isPossible = true;
                answer = cnt;
                return;
            }
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (!visit[ny][nx] && map[ny][nx] == 1) {
                    visit[ny][nx] = true;
                    q.add(new Point(nx, ny, cnt + 1));
                }
            }
        }
    }

    static class Point {
        int x, y, cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}