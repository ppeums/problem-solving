class Solution {
    static char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static char[][] input;
    static boolean[] visit;
    static String str;
    static int answer;

    public int solution(int n, String[] data) {
        input = new char[n][5];
        visit = new boolean[8];
        str = "";
        answer = 0;
        for (int i = 0; i < n; i++)
            input[i] = data[i].toCharArray();
        DFS(0);
        return answer;
    }

    static void DFS(int cnt) {
        if (cnt == 8) {
            boolean isAnswer = true;
            for (int i = 0; i < input.length; i++) {
                char f1 = input[i][0], f2 = input[i][2], op = input[i][3];
                int num = input[i][4] - '0' + 1, i1 = str.indexOf(f1), i2 = str.indexOf(f2), dist = Math.abs(i1 - i2);
                if (op == '=') {
                    if (dist != num) {
                        isAnswer = false;
                        break;
                    }
                } else if (op == '<') {
                    if (dist >= num) {
                        isAnswer = false;
                        break;
                    }
                } else {
                    if (dist <= num) {
                        isAnswer = false;
                        break;
                    }
                }
            }
            if (isAnswer) answer++;
            return;
        }
        for (int i = 0; i < 8; i++) {
            if (!visit[i]) {
                visit[i] = true;
                str += friends[i];
                DFS(cnt + 1);
                str = str.substring(0, str.length() - 1);
                visit[i] = false;
            }
        }
    }
}