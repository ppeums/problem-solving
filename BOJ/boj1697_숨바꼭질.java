import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int MIN, MAX, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        MAX = 100000;
        visited = new boolean[MAX + 1];
        bfs(N, K);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int start, int target) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(start, 0));
        visited[start] = true;
        while (!q.isEmpty()) {
            int x = q.peek().x;
            int sec = q.peek().sec;
            q.poll();
            if (x == target) {
                answer = sec;
                return;
            }
            if (x - 1 >= MIN && !visited[x - 1]) {
                q.add(new Point(x - 1, sec + 1));
                visited[x - 1] = true;
            }
            if (x + 1 <= MAX && !visited[x + 1]) {
                q.add(new Point(x + 1, sec + 1));
                visited[x + 1] = true;
            }
            if (x * 2 <= MAX && !visited[x * 2]) {
                q.add(new Point(x * 2, sec + 1));
                visited[x * 2] = true;
            }
        }
    }

    static class Point {
        int x, sec;

        public Point(int x, int sec) {
            this.x = x;
            this.sec = sec;
        }
    }
}