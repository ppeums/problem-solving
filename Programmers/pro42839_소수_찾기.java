import java.util.Arrays;
import java.util.HashSet;

class Solution {
    static HashSet<Integer> hs = new HashSet<>();
    static boolean[] visit;
    static String[] s;
    static String input;
    static int answer = 0;

    public int solution(String numbers) {
        input = numbers;
        s = new String[input.length()];
        visit = new boolean[input.length()];
        for (int i = 1; i <= input.length(); i++) {
            Arrays.fill(s, "");
            Arrays.fill(visit, false);
            DFS(0, i);
        }
        return answer;
    }

    static void DFS(int cnt, int N) {
        if (cnt == N) {
            int num = Integer.parseInt(s[N - 1]);
            if (!hs.contains(num) && num >= 2) {
                hs.add(num);
                for (int i = 2; i <= num / 2; i++)
                    if (num % i == 0) return;
                answer++;
            }
            return;
        }
        for (int i = 0; i < input.length(); i++) {
            if (!visit[i]) {
                String tmp = s[N - 1];
                s[N - 1] += input.charAt(i);
                visit[i] = true;
                DFS(cnt + 1, N);
                s[N - 1] = tmp;
                visit[i] = false;
            }
        }
    }
}