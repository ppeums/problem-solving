import java.util.Arrays;

class Solution {
    static int n;
    static int[] dist;
    static int[][] time;
    static boolean[] visit;

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        n = N;
        dist = new int[N + 1];
        time = new int[N + 1][N + 1];
        visit = new boolean[N + 1];
        for (int[] r : road) {
            time[r[0]][r[1]] = time[r[1]][r[0]] = (time[r[0]][r[1]] == 0) ? r[2] : Math.min(r[2], time[r[0]][r[1]]);
        }
        dijkstra();
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }
        return answer;
    }

    static void dijkstra() {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        visit[1] = true;
        for (int i = 1; i <= n; i++) {
            if (time[1][i] > 0) {
                dist[i] = time[1][i];
            }
        }
        for (int i = 0; i < n - 1; i++) {
            int min = Integer.MAX_VALUE;
            int idx = -1;
            for (int j = 1; j <= n; j++) {
                if (!visit[j] && min > dist[j]) {
                    min = dist[j];
                    idx = j;
                }
            }
            visit[idx] = true;
            for (int j = 1; j <= n; j++) {
                if (!visit[j] && time[idx][j] > 0 && dist[j] > dist[idx] + time[idx][j]) {
                    dist[j] = dist[idx] + time[idx][j];
                }
            }
        }
    }
}