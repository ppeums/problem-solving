import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            Queue<Doc> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int doc = Integer.parseInt(st.nextToken());
                pq.add(doc);
                if (j == M) {
                    q.add(new Doc(doc, true));
                } else {
                    q.add(new Doc(doc, false));
                }
            }
            int answer = 1;
            while (true) {
                if (pq.peek() == q.peek().importance) {
                    if (q.peek().isTarget) {
                        bw.write(answer + "\n");
                        break;
                    }
                    pq.poll();
                    q.poll();
                    answer++;
                } else {
                    q.add(q.poll());
                }
            }
            bw.flush();
        }
        bw.close();
        br.close();
    }

    static class Doc {
        int importance;
        boolean isTarget;

        public Doc(int importance, boolean isTarget) {
            this.importance = importance;
            this.isTarget = isTarget;
        }
    }
}