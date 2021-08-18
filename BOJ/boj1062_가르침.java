import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static String[] word;
    static boolean[] visited;
    static int N;
    static int K;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        word = new String[N];
        visited = new boolean[26];

        visited['a' - 'a'] = true;
        visited['c' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;

        for (int i = 0; i < N; i++) {
            word[i] = br.readLine().replaceAll("a|c|i|n|t", "");
        }

        dfs(0, 0);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int start, int cnt) {
        if (cnt == K - 5) {
            countReadableWord();
            return;
        }

        for (int i = start; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, cnt + 1);
                visited[i] = false;
            }
        }
    }

    public static void countReadableWord() {
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            boolean canRead = true;

            for (int j = 0; j < word[i].length(); j++) {
                if (!visited[word[i].charAt(j) - 'a']) {
                    canRead = false;
                    break;
                }
            }

            if (canRead) {
                cnt++;
            }
        }

        answer = Math.max(answer, cnt);
    }
}
