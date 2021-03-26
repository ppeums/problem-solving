import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int cnt = 0;
        boolean isAnswer = false;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(Integer.parseInt(st.nextToken()));
        }
        for (cnt = 0; cnt < T; cnt++) {
            int front = pq.poll();
            if (front == 1) {
                pq.add(front);
                break;
            }
            if (front >= H)
                pq.add(front / 2);
            else {
                isAnswer = true;
                pq.add(front);
                break;
            }
        }
        int front = pq.poll();
        if (isAnswer || front < H)
            sb.append("YES\n" + cnt + "\n");
        else
            sb.append("NO\n" + front + "\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}