import java.util.ArrayList;

class Solution {
    ArrayList<int[]> moveList;

    public int[][] solution(int n) {
        moveList = new ArrayList<>();
        hanoi(n, 1, 3, 2);
        int[][] answer = new int[moveList.size()][2];
        for (int i = 0; i < moveList.size(); i++) {
            answer[i] = moveList.get(i);
        }
        return answer;
    }

    public void hanoi(int n, int start, int end, int mid) {
        if (n == 1) {
            moveList.add(new int[]{start, end});
        } else {
            hanoi(n - 1, start, mid, end);
            moveList.add(new int[]{start, end});
            hanoi(n - 1, mid, end, start);
        }
    }
}