class Solution {
    int[] dist;
    boolean[] visited;
    boolean[][] connected;

    public int solution(int n, int[][] edge) {
        int answer = 0;
        int max = 0;
        dist = new int[n + 1];
        visited = new boolean[n + 1];
        connected = new boolean[n + 1][n + 1];

        for (int[] v : edge) {
            connected[v[0]][v[1]] = true;
            connected[v[1]][v[0]] = true;
        }

        dijkstra(n);

        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dist[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (dist[i] == max) {
                answer++;
            }
        }

        return answer;
    }

    public void dijkstra(int n) {
        for (int i = 1; i <= n; i++) {
            if (connected[i][1]) {
                dist[i] = 1;
            } else {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        dist[1] = 0;
        visited[1] = true;

        for (int t = 0; t < n; t++) {
            int min = Integer.MAX_VALUE;
            int idx = 0;

            for (int i = 1; i <= n; i++) {
                if (!visited[i] && (min > dist[i])) {
                    min = dist[i];
                    idx = i;
                }
            }

            visited[idx] = true;

            for (int i = 1; i <= n; i++) {
                if (!visited[i] && connected[i][idx] && (dist[i] > dist[idx] + 1)) {
                    dist[i] = dist[idx] + 1;
                }
            }
        }
    }
}