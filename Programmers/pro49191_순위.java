import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        Set<Integer>[] winner = new Set[n + 1];
        Set<Integer>[] loser = new Set[n + 1];
        for (int i = 1; i <= n; i++) {
            winner[i] = new HashSet<>();
            loser[i] = new HashSet<>();
        }
        for (int i = 0; i < results.length; i++) {
            loser[results[i][0]].add(results[i][1]);
            winner[results[i][1]].add(results[i][0]);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                Set<Integer> winSet = new HashSet<>();
                for (Integer win : winner[j]) {
                    winSet.addAll(winner[win]);
                }
                winner[j].addAll(winSet);
                Set<Integer> loseSet = new HashSet<>();
                for (Integer lose : loser[j]) {
                    loseSet.addAll(loser[lose]);
                }
                loser[j].addAll(loseSet);
            }
        }
        for (int i = 1; i <= n; i++) {
            if (winner[i].size() + loser[i].size() == n - 1) {
                answer++;
            }
        }
        return answer;
    }
}