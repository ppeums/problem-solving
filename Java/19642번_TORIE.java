import java.io.*;
import java.util.ArrayList;

public class Main {
    static ArrayList<Node> tree[];
    static Node[] node;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        String key = br.readLine();
        Init(input);
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
        for (int i = 0; i <= cnt; i++) {
            tree[i] = new ArrayList<>();
        }
        node[0] = new Node(0, "root", null);
        Node parent = node[0];
        int num = 1;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).equals("]")) {
                parent = parent.parent;
            } else if (!arr.get(i).equals("[")) {
                Node cur = new Node(num, arr.get(i), parent);
                node[num] = cur;
                tree[parent.num].add(cur);
                tree[cur.num].add(parent);
                num++;
                parent = cur;
            }
        }
    }

    static class Node {
        int num;
        String str;
        Node parent;

        public Node(int num, String str, Node parent) {
            this.num = num;
            this.str = str;
            this.parent = parent;
        }
    }
}