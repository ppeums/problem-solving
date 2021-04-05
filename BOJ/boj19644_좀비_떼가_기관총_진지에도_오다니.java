import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int L = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int ML = Integer.parseInt(st.nextToken());
        int MK = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(br.readLine());
        int[] z = new int[L];
        for (int i = 0; i < L; i++) {
            z[i] = Integer.parseInt(br.readLine());
        }
        boolean isAnswer = true;
        boolean[] check = new boolean[L];
        int maxi = MK*ML, use = 0, pass = ML - 1;
        for (int i = 0; i < L; i++) {
            if (z[i] > maxi - (pass * MK)) {
                if (use >= C) {
                    isAnswer = false;
                    break;
                } else {
                    use++;
                    pass++;
                    check[i] = true;
                }
            } else if (z[i] == 0) {
                pass++;
                check[i] = true;
            }
            if (i - ML < 0 || check[i - ML]) {
                pass = (--pass >= 0) ? pass : 0;
            }
        }
        bw.write(isAnswer ? "YES\n" : "NO\n");
        bw.flush();
        bw.close();
        br.close();
    }
}