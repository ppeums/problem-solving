class Solution {
    public int solution(int sticker[]) {
        int n = sticker.length;
        if (n == 1) {
            return sticker[0];
        } else if (n == 2) {
            return Math.max(sticker[0], sticker[1]);
        }
        int[] d1 = new int[n];
        int[] d2 = new int[n];
        d1[0] = sticker[0];
        d1[1] = sticker[0];
        d2[0] = 0;
        d2[1] = sticker[1];
        for (int i = 2; i < n - 1; i++) {
            d1[i] = Math.max(d1[i - 2] + sticker[i], d1[i - 1]);
            d2[i] = Math.max(d2[i - 2] + sticker[i], d2[i - 1]);
        }
        d1[n - 1] = Math.max(d1[n - 2], d1[n - 3]);
        d2[n - 1] = Math.max(d2[n - 3] + sticker[n - 1], d2[n - 2]);
        return Math.max(d1[n - 1], d2[n - 1]);
    }
}