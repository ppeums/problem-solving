import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> q = new LinkedList<>();
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            if (q.remove(city)) {
                answer++;
            } else {
                answer += 5;
            }
            q.add(city);
            if (q.size() > cacheSize) {
                q.poll();
            }
        }
        return answer;
    }
}