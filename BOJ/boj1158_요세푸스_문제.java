import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }
        int idx = 1;
        bw.write("<");
        while (!q.isEmpty()) {
            int now = q.poll();
            if (idx % K == 0) {
                if (q.isEmpty()) {
                    bw.write(Integer.toString(now));
                } else {
                    bw.write(now + ", ");
                }
            } else {
                q.add(now);
            }
            idx++;
        }
        bw.write(">\n");
        bw.flush();
        bw.close();
        br.close();
    }
}