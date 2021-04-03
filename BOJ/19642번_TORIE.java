import java.io.*;
import java.util.ArrayList;

import static java.util.Arrays.fill;

public class Main {
    static ArrayList<Node> tree[];
    static ArrayList<String> line = new ArrayList<>();
    static Node[] node;
    static boolean[] visit, skip;
    static String key, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        key = br.readLine();
        Init(input);
        ArrayList<Index> iarr = new ArrayList<>();
        FindKey(0, "", iarr, 0);
        fill(visit, false);
        ans = "";
        GetAnswer(0);
        if (ans.equals("")) {
            bw.write("torie!\n");
        } else {
            bw.write(ans);
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void GetAnswer(int num) {
        visit[num] = true;
        if (num != 0) {
            ans += ("[" + node[num].str);
        }
        for (int i = 0; i < tree[num].size(); i++) {
            int next = tree[num].get(i).num;
            if (!visit[next] && !skip[next]) {
                GetAnswer(next);
            }
        }
        if (num != 0) {
            ans += "]";
        }
    }

    static void FindKey(int num, String str, ArrayList<Index> iarr, int si) {
        visit[num] = true;
        for (int i = 0; i < tree[num].size(); i++) {
            Node cur = tree[num].get(i);
            Index in = new Index(cur.num, si, si + cur.str.length() - 1);
            if (!visit[cur.num]) {
                iarr.add(in);
                FindKey(cur.num, str + cur.str, iarr, in.start + cur.str.length());
                iarr.remove(iarr.size() - 1);
            }
        }
        if (node[num].isLeaf) {
            line.add(str);
            if (str.indexOf(key) > -1) {
                int ikey = str.indexOf(key);
                for (int i = 0; i < iarr.size(); i++) {
                    if (iarr.get(i).start <= ikey && iarr.get(i).end >= ikey) {
                        skip[iarr.get(i).num] = true;
                        break;
                    }
                }
            }
        }
    }

    static void Init(String input) {
        ArrayList<String> arr = new ArrayList<>();
        String word = "";
        int cnt = 0;
        for (int i = 0; i < input.length(); i++) {
            String tmp = Character.toString(input.charAt(i));
            if (tmp.equals("[") || tmp.equals("]")) {
                if (!word.equals("")) {
                    arr.add(word);
                    word = "";
                    cnt++;
                }
                arr.add(tmp);
            } else {
                word += tmp;
            }
        }
        tree = new ArrayList[cnt + 1];
        node = new Node[cnt + 1];
        visit = new boolean[cnt + 1];
        skip = new boolean[cnt + 1];
        for (int i = 0; i <= cnt; i++) {
            tree[i] = new ArrayList<>();
        }
        node[0] = new Node(0, "", null, false);
        Node parent = node[0];
        int num = 1;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).equals("]")) {
                parent = parent.parent;
            } else if (!arr.get(i).equals("[")) {
                Node cur = new Node(num, arr.get(i), parent, true);
                node[num] = cur;
                tree[parent.num].add(cur);
                tree[cur.num].add(parent);
                num++;
                parent.isLeaf = false;
                parent = cur;
            }
        }
    }

    static class Node {
        int num;
        String str;
        Node parent;
        boolean isLeaf;

        public Node(int num, String str, Node parent, boolean isLeaf) {
            this.num = num;
            this.str = str;
            this.parent = parent;
            this.isLeaf = isLeaf;
        }
    }

    static class Index {
        int num, start, end;

        public Index(int num, int start, int end) {
            this.num = num;
            this.start = start;
            this.end = end;
        }
    }
}