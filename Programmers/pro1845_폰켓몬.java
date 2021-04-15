import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < nums.length; i++)
            s.add(nums[i]);
        if (s.size() >= nums.length / 2)
            answer = nums.length / 2;
        else
            answer = s.size();
        return answer;
    }
}