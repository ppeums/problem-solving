import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] num;
    static int[] oper;
    static int max;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        num = new int[N];
        oper = new int[4];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }

        dfs(N, 1, num[0]);

        bw.write(max + "\n");
        bw.write(min + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int N, int cnt, int result) {
        if (cnt == N) {
            max = Math.max(result, max);
            min = Math.min(result, min);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (oper[i] > 0) {
                oper[i]--;

                if (i == 0) {
                    dfs(N, cnt + 1, result + num[cnt]);
                } else if (i == 1) {
                    dfs(N, cnt + 1, result - num[cnt]);
                } else if (i == 2) {
                    dfs(N, cnt + 1, result * num[cnt]);
                } else {
                    dfs(N, cnt + 1, result / num[cnt]);
                }

                oper[i]++;
            }
        }
    }
}
