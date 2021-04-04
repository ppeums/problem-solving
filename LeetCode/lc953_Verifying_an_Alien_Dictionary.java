class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] idx = new int[26];
        for (int i = 0; i < order.length(); i++) {
            idx[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (j >= words[i + 1].length()) return false;
                int left = words[i].charAt(j) - 'a';
                int right = words[i + 1].charAt(j) - 'a';
                if (idx[left] > idx[right]) return false;
                else if (idx[left] < idx[right]) break;
                else continue;
            }
        }
        return true;
    }
}