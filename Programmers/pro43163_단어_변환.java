class Solution {
    String[] input;
    boolean[] visited;
    int answer;

    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        input = words;
        visited = new boolean[words.length];

        for (int i = 0; i < words.length; i++) {
            if (getDiffCnt(begin, words[i]) == 1) {
                visited[i] = true;
                dfs(1, words[i], target, begin + words[i]);
                visited[i] = false;
            }
        }

        return (answer == Integer.MAX_VALUE) ? 0 : answer;
    }

    public void dfs(int changeCnt, String before, String target, String result) {
        if (before.equals(target)) {
            answer = Math.min(answer, changeCnt);
            return;
        }

        for (int i = 0; i < input.length; i++) {
            if (!visited[i] && getDiffCnt(before, input[i]) == 1) {
                visited[i] = true;
                dfs(changeCnt + 1, input[i], target, result + input[i]);
                visited[i] = false;
            }
        }
    }

    public int getDiffCnt(String s1, String s2) {
        int diffCnt = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCnt++;
            }
        }

        return diffCnt;
    }
}