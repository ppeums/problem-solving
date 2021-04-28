import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] str = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++)
            str[i] = Integer.toString(numbers[i]);
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (Integer.parseInt(s1 + s2) < Integer.parseInt(s2 + s1))
                    return 1;
                else if (Integer.parseInt(s1 + s2) > Integer.parseInt(s2 + s1))
                    return -1;
                else
                    return 0;
            }
        });
        for (int i = 0; i < str.length; i++)
            answer += str[i];
        while (!answer.equals("0") && answer.startsWith("0"))
            answer = answer.substring(1, answer.length());
        return answer;
    }
}