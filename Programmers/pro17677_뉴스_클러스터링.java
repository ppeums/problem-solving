import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> m = new HashMap<>();
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        int total = 0, cnt = 0;
        for (int i = 0; i < str1.length() - 1; i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str1.charAt(i + 1);
            String tmp = Character.toString(ch1) + Character.toString(ch2);
            if (ch1 >= 'a' && ch1 <= 'z' && ch2 >= 'a' && ch2 <= 'z') {
                m.put(tmp, m.getOrDefault(tmp, 0) + 1);
                total++;
            }
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            char ch1 = str2.charAt(i);
            char ch2 = str2.charAt(i + 1);
            String tmp = Character.toString(ch1) + Character.toString(ch2);
            if (ch1 >= 'a' && ch1 <= 'z' && ch2 >= 'a' && ch2 <= 'z') {
                total++;
                if (m.containsKey(tmp) && m.get(tmp) > 0) {
                    m.put(tmp, m.get(tmp) - 1);
                    cnt++;
                }
            }
        }
        total -= cnt;
        if (cnt == 0 && total == 0)
            return 65536;
        else
            return (int) ((double) cnt / (double) total * (double) 65536);
    }
}