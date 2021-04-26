import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static boolean[][] visit;
    static int[][] map;
    static int M, N, area, max, cnt;

    public int[] solution(int m, int n, int[][] picture) {
        M = m; N = n;
        map = picture;
        area = 0; max = 0;
        visit = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && map[i][j] != 0) {
                    area++;
                    cnt = 1;
                    BFS(i, j, map[i][j]);
                    max = Math.max(max, cnt);
                }
            }
        }
        return new int[]{area, max};
    }

    static void BFS(int y, int x, int color) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y, x));
        visit[y][x] = true;
        while (!q.isEmpty()) {
            int qy = q.peek().y;
            int qx = q.peek().x;
            q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = qy + dy[i];
                int nx = qx + dx[i];
                if (ny < 0 || ny >= M || nx < 0 || nx >= N) continue;
                if (!visit[ny][nx] && map[ny][nx] == color) {
                    visit[ny][nx] = true;
                    cnt++;
                    q.add(new Node(ny, nx));
                }
            }
        }
    }

    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}