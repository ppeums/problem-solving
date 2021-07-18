import java.io.*;
import java.util.Arrays;

public class Main {
    static int[] input, answer, tmp;
    static boolean[] visited;
    static boolean hasAnswer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        input = new int[9];
        answer = new int[7];
        tmp = new int[7];
        visited = new boolean[9];
        for (int i = 0; i < 9; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < 9; i++) {
            visited[i] = true;
            tmp[0] = input[i];
            dfs(1, input[i]);
            visited[i] = false;
        }
        Arrays.sort(answer);
        for (int i = 0; i < 7; i++) {
            bw.write(answer[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int cnt, int sum) {
        if (cnt == 7) {
            if (!hasAnswer && sum == 100) {
                answer = tmp.clone();
                hasAnswer = true;
            }
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmp[cnt] = input[i];
                dfs(cnt + 1, sum + input[i]);
                visited[i] = false;
            }
        }
    }
}