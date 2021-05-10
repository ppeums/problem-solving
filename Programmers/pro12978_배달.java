import java.util.Arrays;

class Solution {
    static int n;
    static int[] dist;
    static int[][] cost;
    static boolean[] visit;
    static boolean[][] link;

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        n = N;
        dist = new int[N + 1];
        cost = new int[N + 1][N + 1];
        visit = new boolean[N + 1];
        link = new boolean[N + 1][N + 1];
        for (int i = 0; i < road.length; i++) {
            int start = road[i][0], end = road[i][1], time = road[i][2];
            link[start][end] = link[end][start] = true;
            cost[start][end] = cost[end][start] = (cost[start][end] == 0) ? time : Math.min(time, cost[start][end]);
        }
        dijkstra();
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K)
                answer++;
        }
        return answer;
    }

    static void dijkstra() {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        visit[1] = true;
        for (int i = 1; i <= n; i++) {
            if (link[1][i])
                dist[i] = cost[1][i];
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
                if (!visit[j] && link[idx][j] && dist[j] > dist[idx] + cost[idx][j]) {
                    dist[j] = dist[idx] + cost[idx][j];
                }
            }
        }
    }
}