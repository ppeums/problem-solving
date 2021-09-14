class Solution {
    boolean[] visited;
    String[] input;
    int answer;
    int n;

    public int solution(String begin, String target, String[] words) {
        n = words.length;
        input = words;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i] && (countDiff(begin, input[i]) == 1)) {
                visited[i] = true;
                dfs(1, n, input[i], target);
                visited[i] = false;
            }
        }

        return answer;
    }

    public void dfs(int cnt, int n, String before, String target) {
        if (before.equals(target)) {
            answer = (answer == 0) ? cnt : Math.min(answer, cnt);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i] && (countDiff(before, input[i]) == 1)) {
                visited[i] = true;
                dfs(cnt + 1, n, input[i], target);
                visited[i] = false;
            }
        }
    }

    public int countDiff(String s1, String s2) {
        int cnt = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                cnt++;
            }
        }

        return cnt;
    }
}