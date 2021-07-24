import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int gcd = 0, lcm = 0;
        for (int i = N; i >= 1; i--) {
            if (N % i == 0 && M % i == 0) {
                gcd = i;
                break;
            }
        }
        lcm = gcd * (N / gcd) * (M / gcd);
        bw.write(gcd + "\n" + lcm + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}