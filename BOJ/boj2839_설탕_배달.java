import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        while (N >= 5 && N % 5 != 0) {
            N -= 3;
            ans++;
        }
        if (N % 5 == 0)
            ans += N / 5;
        else if (N % 3 == 0)
            ans += N / 3;
        else
            ans = -1;
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}