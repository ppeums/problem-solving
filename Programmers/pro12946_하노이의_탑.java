import java.util.ArrayList;

class Solution {
    ArrayList<int[]> moves;

    public int[][] solution(int n) {
        moves = new ArrayList<>();
        hanoi(n, 1, 3, 2);
        int[][] answer = new int[moves.size()][2];
        for (int i = 0; i < moves.size(); i++) {
            answer[i] = moves.get(i);
        }
        return answer;
    }

    public void hanoi(int n, int start, int end, int mid) {
        if (n == 1) {
            moves.add(new int[]{start, end});
            return;
        } else {
            hanoi(n - 1, start, mid, end);
            moves.add(new int[]{start, end});
            hanoi(n - 1, mid, end, start);
        }
    }
}