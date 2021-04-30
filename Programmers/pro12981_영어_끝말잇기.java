import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        int idx = 1, person = 2, round = 1;
        boolean isFail = false;
        String before = words[0];
        set.add(before);
        while (true) {
            if (idx == words.length) break;
            String now = words[idx];
            if (before.charAt(before.length() - 1) != (now.charAt(0)) || set.contains(now)) {
                isFail = true;
                break;
            }
            set.add(now);
            before = now;
            idx++;
            person++;
            if (person > n) {
                person = 1;
                round++;
            }
        }
        if (isFail)
            return new int[]{person, round};
        else
            return new int[]{0, 0};
    }
}