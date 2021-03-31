import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> map[];
    static Node[] node;
    static int num = 1;
    static int root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        map = new ArrayList[N + 1];
        node = new Node[N + 1];
        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
            node[i] = new Node(0, 0);
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            while (true) {
                int input = Integer.parseInt(st.nextToken());
                if (input == -1) break;
                map[n].add(input);
            }
        }
        for (int i = 1; i <= N; i++) {
            map[i].sort(null);
        }
        st = new StringTokenizer(br.readLine());
        root = Integer.parseInt(st.nextToken());
        node[root].left = num++;
        DFS(root);
        for (int i = 1; i <= N; i++) {
            sb.append(i + " " + node[i].left + " " + node[i].right + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void DFS(int cur) {
        if(node[cur].left == 0) {
            node[cur].left = num++;
        }
        if (cur != root && map[cur].size() == 1) {
            node[cur].right = num++;
            return;
        }
        for (int i = 0; i < map[cur].size(); i++) {
            int next = map[cur].get(i);
            if (node[next].left == 0 && node[next].right == 0) {
                DFS(next);
            }
        }
        node[cur].right = num++;
    }

    static class Node {
        int left, right;

        public Node (int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}