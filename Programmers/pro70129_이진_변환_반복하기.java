class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        while (true) {
            if (s.equals("1")) break;
            String tmp = "";
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1')
                    tmp += '1';
                else
                    answer[1]++;
            }
            s = Integer.toString(tmp.length(), 2);
            answer[0]++;
        }
        return answer;
    }
}