class Solution {
    int[][] map;
    boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        map = computers;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer++;
                dfs(i, n);
            }
        }

        return answer;
    }

    public void dfs(int start, int n) {
        for (int i = 0; i < n; i++) {
            if (!visited[i] && map[start][i] == 1) {
                visited[i] = true;
                dfs(i, n);
            }
        }
    }
}