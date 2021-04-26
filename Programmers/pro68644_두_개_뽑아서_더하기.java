import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                s.add(numbers[i] + numbers[j]);
            }
        }
        Integer[] tmp = new Integer[s.size()];
        int[] answer = new int[s.size()];
        s.toArray(tmp);
        for (int i = 0; i < s.size(); i++)
            answer[i] = tmp[i].intValue();
        return answer;
    }
}