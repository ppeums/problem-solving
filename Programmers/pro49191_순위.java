import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        Set<Integer>[] win = new Set[n + 1];
        Set<Integer>[] lose = new Set[n + 1];

        for (int i = 1; i <= n; i++) {
            win[i] = new HashSet<>();
            lose[i] = new HashSet<>();
        }

        for (int[] r : results) {
            win[r[1]].add(r[0]);
            lose[r[0]].add(r[1]);
        }

        for (int t = 0; t < n; t++) {
            for (int i = 1; i <= n; i++) {
                Set<Integer> winSet = new HashSet<>();
                Set<Integer> loseSet = new HashSet<>();

                for (int w : win[i]) {
                    winSet.addAll(win[w]);
                }

                for (int l : lose[i]) {
                    loseSet.addAll(lose[l]);
                }

                win[i].addAll(winSet);
                lose[i].addAll(loseSet);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (win[i].size() + lose[i].size() == n - 1) {
                answer++;
            }
        }

        return answer;
    }
}