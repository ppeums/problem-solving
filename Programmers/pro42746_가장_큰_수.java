import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        String[] s = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++)
            s[i] = Integer.toString(numbers[i]);
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (Integer.parseInt(o1 + o2) < Integer.parseInt(o2 + o1))
                    return 1;
                else if (Integer.parseInt(o1 + o2) > Integer.parseInt(o2 + o1))
                    return -1;
                else return 0;
            }
        });
        String answer = Arrays.toString(s).replaceAll("[^0-9]", "");
        while (!answer.equals("0") && answer.startsWith("0"))
            answer = answer.substring(1, answer.length());
        return answer;
    }
}