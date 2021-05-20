class Solution {
    static int answer;
    static String key;
    static String[] arr;
    static boolean[] visit;

    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        key = target;
        arr = words;
        visit = new boolean[words.length];
        dfs(begin, 0);
        return (answer == Integer.MAX_VALUE) ? 0 : answer;
    }

    static void dfs(String before, int cnt) {
        if (before.equals(key)) {
            answer = Math.min(answer, cnt);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!visit[i]) {
                int diff = 0;
                for (int j = 0; j < before.length(); j++) {
                    if (before.charAt(j) != arr[i].charAt(j)) {
                        diff++;
                    }
                }
                if (diff == 1) {
                    visit[i] = true;
                    dfs(arr[i], cnt + 1);
                    visit[i] = false;
                }
            }
        }
    }
}