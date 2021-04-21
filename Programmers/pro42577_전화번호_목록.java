import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++) {
            String tmp = "";
            for (int j = 0; j < phone_book[i].length(); j++) {
                tmp += phone_book[i].charAt(j);
                if (!hm.containsKey(tmp))
                    hm.put(tmp, 1);
                else
                    hm.put(tmp, hm.get(tmp) + 1);
            }
        }
        for (int i = 0; i < phone_book.length; i++) {
            if (hm.get(phone_book[i]) > 1)
                return false;
        }
        return true;
    }
}