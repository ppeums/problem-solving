class Solution {
    public int solution(int n) {
        String input = Integer.toString(n, 2);
        int[] cnt = new int[2];
        int num = n;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '1')
                cnt[0]++;
        }
        while (true) {
            num++;
            cnt[1] = 0;
            String s = Integer.toString(num, 2);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1')
                    cnt[1]++;
            }
            if (cnt[0] == cnt[1] && num > n) break;
        }
        return num;
    }
}