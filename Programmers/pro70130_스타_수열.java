import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        for (int key : map.keySet()) {
            list.add(new int[]{key, map.get(key)});
        }
        Collections.sort(list, (o1, o2) -> Integer.compare(o2[1], o1[1]));
        for (int i = 0; i < list.size(); i++) {
            int star = list.get(i)[0];
            if (list.get(i)[1] * 2 <= answer) {
                break;
            }
            int tmp = 0;
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] != a[j + 1] && (a[j] == star || a[j + 1] == star)) {
                    tmp += 2;
                    j++;
                }
            }
            answer = Math.max(answer, tmp);
        }
        return answer;
    }
}