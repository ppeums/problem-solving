import java.util.Arrays;

class Solution {
    static int[] dist;
    static boolean[] visit;
    static boolean[][] link;

    public int solution(int n, int[][] edge) {
        int answer = 0;
        dist = new int[n + 1];
        visit = new boolean[n + 1];
        link = new boolean[n + 1][n + 1];
        for (int i = 0; i < edge.length; i++) {
            link[edge[i][0]][edge[i][1]] = true;
            link[edge[i][1]][edge[i][0]] = true;
        }
        dijkstra(n);
        Arrays.sort(dist, 1, n + 1);
        for (int i = 1; i <= n; i++) {
            if (dist[n] == dist[i]) {
                answer++;
            }
        }
        return answer;
    }

    static void dijkstra(int n) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        visit[1] = true;
        for (int i = 1; i <= n; i++) {
            if (link[1][i]) {
                dist[i] = 1;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            int min = Integer.MAX_VALUE;
            int idx = -1;
            for (int j = 1; j <= n; j++) {
                if (!visit[j] && dist[j] < min) {
                    min = dist[j];
                    idx = j;
                }
            }
            visit[idx] = true;
            for (int j = 1; j <= n; j++) {
                if (!visit[j] && link[idx][j] && dist[j] > dist[idx] + 1) {
                    dist[j] = dist[idx] + 1;
                }
            }
        }
    }
}