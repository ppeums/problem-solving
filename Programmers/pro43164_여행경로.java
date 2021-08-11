class Solution {
    String[][] input;
    boolean[] used;
    String answer;
    int N;

    public String[] solution(String[][] tickets) {
        answer = "";
        input = tickets;
        N = tickets.length;
        used = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (!used[i] && tickets[i][0].equals("ICN")) {
                String route = tickets[i][0] + " " + tickets[i][1];
                used[i] = true;
                dfs(1, N, tickets[i][1], route);
                used[i] = false;
            }
        }

        return answer.split(" ");
    }

    public void dfs(int cnt, int target, String prev, String route) {
        if (cnt == target) {
            if (answer.equals("")) {
                answer = route;
            } else {
                answer = (answer.compareTo(route) > 0) ? route : answer;
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!used[i] && input[i][0].equals(prev)) {
                String newRoute = route + " " + input[i][1];
                used[i] = true;
                dfs(cnt + 1, target, input[i][1], newRoute);
                used[i] = false;
            }
        }
    }
}