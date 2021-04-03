import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int W0, I0, T, D, I, A, w1, w2, i1, i2;
    static boolean isDanger1, isDanger2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        W0 = Integer.parseInt(st.nextToken());
        I0 = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken());
        I = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        w1 = w2 = W0;
        i1 = i2 = I0;
        for (int i = 0; i < D; i++) {
            int ch1 = I - (i1 + A);
            int ch2 = I - (i2 + A);
            w1 += ch1;
            w2 += ch2;
            if (Math.abs(ch2) > T)
                i2 += Math.floorDiv(ch2, 2);
            if (w1 <= 0 || i1 <= 0)
                isDanger1 = true;
            if (w2 <= 0 || i2 <= 0)
                isDanger2 = true;
        }
        if (isDanger1)
            sb.append("Danger Diet\n");
        else
            sb.append(w1 + " " + i1 + "\n");
        if (isDanger2)
            sb.append("Danger Diet\n");
        else {
            sb.append(w2 + " " + i2 + " ");
            if (i1 - i2 > 0)
                sb.append("YOYO\n");
            else
                sb.append("NO\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}