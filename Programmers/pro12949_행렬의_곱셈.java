import java.util.ArrayList;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                int sum = 0;
                for (int k = 0; k < arr2.length; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }
                arr.add(sum);
            }
        }
        int idx = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                answer[i][j] = arr.get(idx++);
            }
        }
        return answer;
    }
}