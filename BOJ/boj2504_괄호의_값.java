import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        if (!isCorrectBracket(str)) {
            bw.write(0 + "\n");
        } else {
            bw.write(getBracketValue(str) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int getBracketValue(String str) {
        Stack<String> stack = new Stack<>();
        int answer = 0;

        for (int i = 0; i < str.length(); i++) {
            String ch = str.substring(i, i + 1);

            if ((ch.equals("(")) || (ch.equals("["))) {
                stack.push(ch);
            } else {
                String peek = stack.peek();

                if (ch.equals(")")) {
                    if (peek.equals("(")) {
                        stack.pop();
                        stack.push("2");
                    } else {
                        int num = 0;

                        while (!stack.peek().equals("(")) {
                            num += Integer.parseInt(stack.pop());
                        }

                        stack.pop();
                        stack.push(Integer.toString(num * 2));
                    }
                } else if (ch.equals("]")) {
                    if (peek.equals("[")) {
                        stack.pop();
                        stack.push("3");
                    } else {
                        int num = 0;

                        while (!stack.peek().equals("[")) {
                            num += Integer.parseInt(stack.pop());
                        }

                        stack.pop();
                        stack.push(Integer.toString(num * 3));
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
            answer += Integer.parseInt(stack.pop());
        }

        return answer;
    }

    public static boolean isCorrectBracket(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if ((ch == '(') || (ch == '[')) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char peek = stack.peek();

                if (((ch == ')') && (peek == '('))
                        || ((ch == ']') && (peek == '['))) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
