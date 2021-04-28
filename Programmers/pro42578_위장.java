import java.util.HashMap;
import java.util.Map;

class Solution {
    static int answer = 0, idx = 0;
    static int[] arr;

    public int solution(String[][] clothes) {
        Map<String, Integer> m = new HashMap<>();
        for (int i = 0; i < clothes.length; i++)
            m.put(clothes[i][1], m.getOrDefault(clothes[i][1], 0) + 1);
        arr = new int[m.size()];
        for (Integer i : m.values())
            arr[idx++] = i;
        DFS(0, 0);
        return answer;
    }

    static void DFS(int cnt, int start) {
        if (cnt == idx) return;
        for (int i = start; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                answer++;
                DFS(cnt + 1, i + 1);
            }
        }
    }
}