import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
    public int[] solution(String s) {
        s = s.replaceAll("[^0-9]", " ").replaceAll(" {2,}", " ").trim();
        String[] arr = s.split(" ");
        Map<String, Integer> m = new HashMap<>();
        for (int i = 0; i < arr.length; i++)
            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
        List<Entry<String, Integer>> list = new ArrayList<>(m.entrySet());
        list.sort(Entry.comparingByValue());
        int[] answer = new int[list.size()];
        int idx = 0;
        for (int i = answer.length - 1; i >= 0; i--) {
            int tmp = Integer.parseInt(list.get(idx++).getKey());
            answer[i] = tmp;
        }
        return answer;
    }
}