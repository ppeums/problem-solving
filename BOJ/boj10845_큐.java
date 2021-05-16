import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> q = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String op = br.readLine();
            if (op.contains("push")) {
                int num = Integer.parseInt(op.substring(5));
                q.add(num);
            } else if (op.equals("pop")) {
                if (q.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(q.poll() + "\n");
                }
            } else if (op.equals("size")) {
                bw.write(q.size() + "\n");
            } else if (op.equals("empty")) {
                if (q.isEmpty()) {
                    bw.write(1 + "\n");
                } else {
                    bw.write(0 + "\n");
                }
            } else if (op.equals("front")) {
                if (q.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(q.peek() + "\n");
                }
            } else if (op.equals("back")) {
                if (q.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    int size = q.size();
                    for (int j = 0; j < size; j++) {
                        int tmp = q.poll();
                        if (j == size - 1) {
                            bw.write(tmp + "\n");
                        }
                        q.add(tmp);
                    }
                }
            }
            bw.flush();
        }
        bw.close();
        br.close();
    }
}