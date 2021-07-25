import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int sum = 0, min = Integer.MAX_VALUE;
        for (int num = M; num <= N; num++) {
            if (num < 2) {
                continue;
            }
            boolean isPrimeNumber = true;
            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) {
                    isPrimeNumber = false;
                    break;
                }
            }
            if (isPrimeNumber) {
                sum += num;
                min = Math.min(min, num);
            }
        }
        if (sum == 0) {
            bw.write(-1 + "\n");
        } else {
            bw.write(sum + "\n" + min + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
