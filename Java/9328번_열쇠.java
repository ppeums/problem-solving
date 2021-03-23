import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int T, H, W, ans;
    static char[][] map;
    static boolean[][] visit;
    static boolean[] key;
    static ArrayList<Point>[] gate;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H + 2][W + 2];
            visit = new boolean[H + 2][W + 2];
            key = new boolean[26];
            gate = new ArrayList[26];
            ans = 0;
            for (int i = 0; i < 26; i++) {
                gate[i] = new ArrayList<>();
            }
            for (int i = 0; i < H + 2; i++) {
                for (int j = 0; j < W + 2; j++) {
                    map[i][j] = '.';
                }
            }
            for (int i = 1; i <= H; i++) {
                String input = br.readLine();
                for (int j = 1; j <= W; j++) {
                    map[i][j] = input.charAt(j - 1);
                }
            }
            String inputKey = br.readLine();
            if (!inputKey.equals("0")) {
                for (int i = 0; i < inputKey.length(); i++) {
                    int tmp = inputKey.charAt(i) - 'a';
                    key[tmp] = true;
                }
            }
            BFS();
            System.out.println(ans);
        }
        br.close();
    }

    static void BFS() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));
        visit[0][0] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                if (ny < 0 || ny >= H + 2 || nx < 0 || nx >= W + 2) continue;
                if (map[ny][nx] == '*' || visit[ny][nx]) continue;
                char ch = map[ny][nx];
                if (ch >= 'A' && ch <= 'Z') {
                    int idx = ch - 'A';
                    if (key[idx]) {
                        map[ny][nx] = '.';
                        visit[ny][nx] = true;
                        q.add(new Point(ny, nx));
                    } else {
                        gate[idx].add(new Point(ny, nx));
                    }
                } else if (ch >= 'a' && ch <= 'z') {
                    int idx = map[ny][nx] - 'a';
                    map[ny][nx] = '.';
                    key[idx] = true;
                    visit[ny][nx] = true;
                    q.add(new Point(ny, nx));

                    for (int j = 0; j < 26; j++) {
                        if (gate[j].size() > 0 && key[j]) {
                            for (int k = 0; k < gate[j].size(); k++) {
                                Point tmp = gate[j].get(k);
                                map[tmp.y][tmp.x] = '.';
                                visit[tmp.y][tmp.x] = true;
                                q.add(new Point(tmp.y, tmp.x));
                            }
                        }
                    }
                } else if (ch == '$') {
                    ans++;
                    map[ny][nx] = '.';
                    visit[ny][nx] = true;
                    q.add(new Point(ny, nx));
                } else {
                    visit[ny][nx] = true;
                    q.add(new Point(ny, nx));
                }
            }
        }
    }

    static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}