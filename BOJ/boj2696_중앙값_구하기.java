import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int M = Integer.parseInt(br.readLine());
            int[] arr = new int[M];
            ArrayList<Integer> list = new ArrayList<>();
            int cnt = (M + 1) / 2;
            int[] answer = new int[cnt];
            cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                if (i > 0 && i % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }
                arr[i] = Integer.parseInt(st.nextToken());
                list.add(arr[i]);
                if (i % 2 == 0) {
                    Collections.sort(list);
                    answer[cnt] = list.get(i / 2);
                    cnt++;
                }
            }
            bw.write(cnt + "\n");
            for (int i = 0; i < cnt; i++) {
                if (i > 0 && i % 10 == 0) {
                    bw.write("\n");
                }
                bw.write(answer[i] + " ");
            }
            bw.write("\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}