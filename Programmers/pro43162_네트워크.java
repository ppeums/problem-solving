class Solution {
    static int N;
    static int[][] map;
    static boolean[] visit;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        N = n;
        map = computers;
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                DFS(i);
                answer++;
            }
        }
        return answer;
    }

    static void DFS(int start) {
        for (int i = 0; i < N; i++) {
            if (!visit[i] && map[i][start] == 1) {
                visit[i] = true;
                DFS(i);
            }
        }
    }
}