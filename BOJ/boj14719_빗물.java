import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] block = new int[W];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < W; i++) {
            block[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < W - 1; i++) {
            int rain = 0;
            int leftMax = 0;
            int rightMax = 0;

            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, block[j]);
            }

            for (int j = i + 1; j < W; j++) {
                rightMax = Math.max(rightMax, block[j]);
            }

            rain = Math.min(leftMax, rightMax);

            if (rain > block[i]) {
                answer += rain - block[i];
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
