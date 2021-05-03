import java.util.ArrayList;

class Solution {
    static ArrayList<Integer>[] arr;
    static boolean[] visit;
    static int[][] time;
    static int[] dist;
    static int n;

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        arr = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        time = new int[N + 1][N + 1];
        dist = new int[N + 1];
        n = N;
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            arr[a].add(b);
            arr[b].add(a);
            time[a][b] = time[b][a] = (time[a][b] == 0) ? road[i][2] : Math.min(time[a][b], road[i][2]);
        }
        dijkstra();
        for (int i = 1; i <= n; i++) {
            if (dist[i] <= K)
                answer++;
        }
        return answer;
    }

    static void dijkstra() {
        dist[1] = 0;
        visit[1] = true;
        for (int i = 0; i < arr[1].size(); i++) {
            int next = arr[1].get(i);
            dist[next] = time[1][next];
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
                if (!visit[j] && time[idx][j] != 0 && dist[j] > dist[idx] + time[idx][j])
                    dist[j] = dist[idx] + time[idx][j];
            }
        }
    }
}