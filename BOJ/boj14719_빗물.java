import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] arr = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        for (int i = 1; i < W - 1; i++) {
            int left = 0, right = 0, min = 0;
            for (int j = 0; j < i; j++) {
                left = Math.max(left, arr[j]);
            }
            for (int j = i + 1; j < W; j++) {
                right = Math.max(right, arr[j]);
            }
            min = Math.min(left, right);
            if (min > arr[i]) {
                sum += min - arr[i];
            }
        }
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}