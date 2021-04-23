import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int l = 0, r = people.length - 1;
        while (l < r) {
            int sum = people[l] + people[r];
            if (sum <= limit)
                l++;
            r--;
            answer++;
        }
        if (l == r) answer++;
        return answer;
    }
}