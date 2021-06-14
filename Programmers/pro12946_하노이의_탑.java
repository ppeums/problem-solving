import java.util.ArrayList;

class Solution {
    static ArrayList<int[]> moves;

    public int[][] solution(int n) {
        moves = new ArrayList<>();
        hanoi(n, 1, 3, 2);
        int[][] answer = new int[moves.size()][2];
        for (int i = 0; i < moves.size(); i++) {
            answer[i][0] = moves.get(i)[0];
            answer[i][1] = moves.get(i)[1];
        }
        return answer;
    }

    static void hanoi(int n, int start, int end, int via) {
        if (n == 1) {
            moves.add(new int[]{start, end});
        } else {
            hanoi(n - 1, start, via, end);
            moves.add(new int[]{start, end});
            hanoi(n - 1, via, end, start);
        }
    }
}