import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0, l = 0, r = people.length - 1;
        Arrays.sort(people);
        while (l < r) {
            if (people[l] + people[r] <= limit)
                l++;
            answer++;
            r--;
        }
        if (l == r) answer++;
        return answer;
    }
}