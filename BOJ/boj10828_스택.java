import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String op = br.readLine();
            if (op.contains("push")) {
                int num = Integer.parseInt(op.substring(5));
                stack.push(num);
            } else {
                if (op.equals("pop")) {
                    if (stack.isEmpty())
                        bw.write(-1 + "\n");
                    else
                        bw.write(stack.pop() + "\n");
                } else if (op.equals("size")) {
                    bw.write(stack.size() + "\n");
                } else if (op.equals("empty")) {
                    if (stack.isEmpty())
                        bw.write(1 + "\n");
                    else
                        bw.write(0 + "\n");
                } else {
                    if (stack.isEmpty())
                        bw.write(-1 + "\n");
                    else
                        bw.write(stack.peek() + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}