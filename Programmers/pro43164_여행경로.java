import java.util.ArrayList;
import java.util.Collections;

class Solution {
    static String[][] input;
    static boolean[] visit;
    static ArrayList<String> answer;

    public String[] solution(String[][] tickets) {
        input = tickets;
        visit = new boolean[tickets.length];
        answer = new ArrayList<>();
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals("ICN")) {
                visit[i] = true;
                String route = tickets[i][0] + "," + tickets[i][1];
                dfs(tickets[i][1], route, 1);
                visit[i] = false;
            }
        }
        Collections.sort(answer);
        return answer.get(0).split(",");
    }

    static void dfs(String start, String route, int cnt) {
        if (cnt == input.length) {
            answer.add(route);
            return;
        }
        for (int i = 0; i < input.length; i++) {
            if (!visit[i] && input[i][0].equals(start)) {
                visit[i] = true;
                dfs(input[i][1], route + "," + input[i][1], cnt + 1);
                visit[i] = false;
            }
        }
    }
}