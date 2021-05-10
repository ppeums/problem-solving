import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> q = new LinkedList<>();
        if (cacheSize == 0)
            return cities.length * 5;
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            if (q.contains(city)) {
                answer += 1;
                q.remove(city);
            } else {
                if (q.size() == cacheSize)
                    q.poll();
                answer += 5;
            }
            q.add(city);
        }
        return answer;
    }
}