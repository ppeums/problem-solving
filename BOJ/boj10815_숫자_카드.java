import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] na = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            na[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        int[] ma = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            ma[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(na);
        for (int i = 0; i < M; i++) {
            boolean isAnswer = false;
            int left = 0, right = N - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (ma[i] == na[mid]) {
                    bw.write(1 + " ");
                    isAnswer = true;
                    break;
                } else if (ma[i] < na[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (!isAnswer)
                bw.write(0 + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}