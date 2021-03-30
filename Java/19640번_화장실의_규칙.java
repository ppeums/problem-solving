import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Person> q[] = new LinkedList[M];
        PriorityQueue<Person> pq = new PriorityQueue<Person>();
        for (int i = 0; i < M; i++) {
            q[i] = new LinkedList<>();
        }
        int line = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int bath = Integer.parseInt(st.nextToken());
            boolean isDeca = false;
            if (i == K) {
                isDeca = true;
            }
            q[line].add(new Person(day, bath, line++, isDeca));
            if (line == M) line = 0;
        }
        for (int i = 0; i < M; i++) {
            if (!q[i].isEmpty()) {
                Person front = q[i].poll();
                pq.add(front);
            }
        }
        int ans = 0;
        while (!pq.peek().isDeca) {
            Person front = pq.poll();
            ans++;
            if (!q[front.line].isEmpty()) {
                pq.add(q[front.line].poll());
            }
        }
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Person implements Comparable<Person> {
        int day, bath, line;
        boolean isDeca;

        public Person(int day, int bath, int line, boolean isDeca) {
            this.day = day;
            this.bath = bath;
            this.line = line;
            this.isDeca = isDeca;
        }

        @Override
        public int compareTo(Person o) {
            if (this.day < o.day) {
                return 1;
            } else if (this.day == o.day) {
                if (this.bath < o.bath) {
                    return 1;
                } else if (this.bath == o.bath) {
                    if (this.line > o.line) {
                        return 1;
                    } else return -1;
                } else return -1;

            }
            return -1;
        }
    }
}