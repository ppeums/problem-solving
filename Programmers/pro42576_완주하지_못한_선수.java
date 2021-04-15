import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> hm = new HashMap<>();
        for (String p : participant) {
            hm.put(p, 0);
        }
        for (String p : participant) {
            hm.put(p, hm.get(p) + 1);
        }
        for (String c : completion) {
            hm.put(c, hm.get(c) - 1);
        }
        for (String p : participant) {
            if (hm.get(p) == 1) {
                answer = p;
                break;
            }
        }
        return answer;
    }
}