import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < moves.length; i++) {
            int idx = moves[i];
            for (int j = 0; j < board.length; j++) {
                int now = board[j][idx - 1];
                if (now != 0) {
                    if (!s.empty() && s.peek() == now) {
                        s.pop();
                        answer += 2;
                    } else s.add(now);
                    board[j][idx - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}