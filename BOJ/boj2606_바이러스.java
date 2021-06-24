import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] connected;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        connected = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            connected[a][b] = connected[b][a] = true;
        }
        visited[1] = true;
        for (int i = 1; i <= N; i++) {
            if (connected[i][1] && !visited[i]) {
                visited[i] = true;
                answer++;
                dfs(i, N);
            }
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int before, int N) {
        for (int i = 1; i <= N; i++) {
            if (connected[i][before] && !visited[i]) {
                visited[i] = true;
                answer++;
                dfs(i, N);
            }
        }
    }
}