import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] enemy = new int[X];
        int[] item = new int[Y];
        int esum = 0, isum = 0;
        for (int i = 0; i < X; i++) {
            st = new StringTokenizer(br.readLine());
            enemy[i] = Integer.parseInt(st.nextToken());
            esum += enemy[i];
        }
        for (int i = 0; i < Y; i++) {
            st = new StringTokenizer(br.readLine());
            item[i] = Integer.parseInt(st.nextToken());
            isum += item[i];
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int cur = M, ei = 0, ii = 0;
        if (M - esum + isum <= 0) {
            sb.append(0 + "\n");
        } else if (X == 0) {
            for (int i = 0; i < Y; i++) {
                sb.append((i + 1) + "\n");
            }
        } else if (Y == 0) {
            for (int i = 0; i < X; i++) {
                sb.append((i + 1) * -1 + "\n");
            }
        } else {
            while (true) {
                if (ei == X && ii == Y) break;
                if (ei == X) {
                    cur += item[ii];
                    ans.add(ii + 1);
                    ii++;
                } else {
                    if (cur - enemy[ei] > 0) {
                        cur -= enemy[ei];
                        ans.add((ei + 1) * -1);
                        ei++;
                    } else {
                        cur += item[ii];
                        ans.add(ii + 1);
                        ii++;
                    }
                }
            }
            for (int i = 0; i < ans.size(); i++) {
                sb.append(ans.get(i) + "\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}