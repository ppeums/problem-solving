import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] record) {
        String[][] input = new String[record.length][3];
        Map<String, String> m = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < record.length; i++) {
            input[i] = record[i].split(" ");
            if (input[i][0].equals("Enter")) {
                m.put(input[i][1], input[i][2]);
                cnt++;
            } else if (input[i][0].equals("Leave"))
                cnt++;
            else
                m.put(input[i][1], input[i][2]);
        }
        String[] answer = new String[cnt];
        int idx = 0;
        for (int i = 0; i < record.length; i++) {
            if (input[i][0].equals("Enter"))
                answer[idx++] = m.get(input[i][1]) + "님이 들어왔습니다.";
            else if (input[i][0].equals("Leave"))
                answer[idx++] = m.get(input[i][1]) + "님이 나갔습니다.";
        }
        return answer;
    }
}