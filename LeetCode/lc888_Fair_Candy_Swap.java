class Solution {

    public int[] fairCandySwap(int[] A, int[] B) {
        int[] ans = new int[2];
        int asum = 0, bsum = 0;
        for (int i : A) {
            asum += i;
        }
        for (int i : B) {
            bsum += i;
        }
        int diff = (bsum - asum) / 2;
        Set<Integer> set = new HashSet<>();
        for (int i : B) set.add(i);
        for (int i : A) {
            if (set.contains(i + diff)) {
                ans = new int[]{i, i + diff};
                break;
            }
        }
        return ans;
    }
}