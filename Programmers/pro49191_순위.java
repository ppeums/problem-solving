import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        Player[] plist = new Player[n + 1];
        for (int i = 1; i <= n; i++) {
            plist[i] = new Player();
        }
        for (int i = 0; i < results.length; i++) {
            int win = results[i][0];
            int lose = results[i][1];
            plist[win].weak.add(lose);
            plist[lose].strong.add(win);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                Set<Integer> sset = new HashSet<>();
                for (Integer strong : plist[j].strong) {
                    for (Integer st : plist[strong].strong) {
                        sset.add(st);
                    }
                }
                plist[j].strong.addAll(sset);
                Set<Integer> wset = new HashSet<>();
                for (Integer weak : plist[j].weak) {
                    for (Integer wk : plist[weak].weak) {
                        wset.add(wk);
                    }
                }
                plist[j].weak.addAll(wset);
            }
        }
        for (int i = 1; i <= n; i++) {
            if (plist[i].strong.size() + plist[i].weak.size() == n - 1) {
                answer++;
            }
        }
        return answer;
    }

    static class Player {
        Set<Integer> strong = new HashSet<>();
        Set<Integer> weak = new HashSet<>();
    }
}