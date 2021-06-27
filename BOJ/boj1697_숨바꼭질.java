import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int answer;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
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
            int time = q.peek().time;
            q.poll();
            if (x == target) {
                answer = time;
                break;
            }
            if (x - 1 >= 0 && !visited[x - 1]) {
                visited[x - 1] = true;
                q.add(new Point(x - 1, time + 1));
            }
            if (x + 1 <= 100000 && !visited[x + 1]) {
                visited[x + 1] = true;
                q.add(new Point(x + 1, time + 1));
            }
            if (x * 2 <= 100000 && !visited[x * 2]) {
                visited[x * 2] = true;
                q.add(new Point(x * 2, time + 1));
            }
        }
    }

    static class Point {
        int x, time;

        public Point(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}