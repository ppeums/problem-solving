import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = {0, 0, 1, 7, 4, 2, 6, 8, 10, 18, 22, 20, 28, 68, 88, 108, 188, 200};
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            String min = "", max = "";
            if (N <= 17) {
                min = Integer.toString(arr[N]);
            } else {
                int tmp = N, cnt = 0;
                while (true) {
                    if (tmp <= 17) break;
                    tmp -= 7;
                    cnt++;
                }
                min = Integer.toString(arr[tmp]);
                for (int i = 0; i < cnt; i++) {
                    min += "8";
                }
            }
            if (N % 2 == 0) {
                for (int i = 0; i < N / 2; i++) {
                    max += "1";
                }
            } else {
                max += "7";
                for (int i = 0; i < (N - 3) / 2; i++) {
                    max += "1";
                }
            }
            bw.write(min + " " + max + "\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}