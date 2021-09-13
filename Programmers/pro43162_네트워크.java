class Solution {
    boolean[] visited;
    int[][] connect;
    int answer;

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        connect = computers;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer++;
                dfs(i, n);
            }
        }

        return answer;
    }

    public void dfs(int before, int n) {
        for (int i = 0; i < n; i++) {
            if (!visited[i] && connect[before][i] == 1) {
                visited[i] = true;
                dfs(i, n);
            }
        }
    }
}