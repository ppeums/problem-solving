import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> dq = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String op = br.readLine();
            if (op.contains("push_front")) {
                int num = Integer.parseInt(op.substring(11));
                dq.addFirst(num);
            } else if (op.contains("push_back")) {
                int num = Integer.parseInt(op.substring(10));
                dq.addLast(num);
            } else if (op.equals("pop_front")) {
                if (dq.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(dq.pollFirst() + "\n");
                }
            } else if (op.equals("pop_back")) {
                if (dq.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(dq.pollLast() + "\n");
                }
            } else if (op.equals("size")) {
                bw.write(dq.size() + "\n");
            } else if (op.equals("empty")) {
                if (dq.isEmpty()) {
                    bw.write(1 + "\n");
                } else {
                    bw.write(0 + "\n");
                }
            } else if (op.equals("front")) {
                if (dq.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(dq.peekFirst() + "\n");
                }
            } else if (op.equals("back")) {
                if (dq.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(dq.peekLast() + "\n");
                }
            }
            bw.flush();
        }
        bw.close();
        br.close();
    }
}