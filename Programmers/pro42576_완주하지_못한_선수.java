import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> h = new HashMap<>();
        for (String p : participant) {
            h.put(p, 0);
        }
        for (String p : participant) {
            h.put(p, h.get(p) + 1);
        }
        for (String c : completion) {
            h.put(c, h.get(c) - 1);
        }
        for (String p : participant) {
            if (h.get(p) == 1) {
                answer = p;
                break;
            }
        }
        return answer;
    }
}