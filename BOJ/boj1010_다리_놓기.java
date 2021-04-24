import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] d = new int[N + 1][M + 1];
            for (int i = 1; i <= M; i++)
                d[1][i] = i;
            for (int i = 2; i <= N; i++) {
                for (int j = i; j <= M; j++) {
                    for (int k = j - 1; k >= i - 1; k--) {
                        d[i][j] += d[i - 1][k];
                    }
                }
            }
            bw.write(d[N][M] + "\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}