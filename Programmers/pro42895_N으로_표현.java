import java.util.LinkedHashSet;
import java.util.Iterator;
import java.util.Set;

class Solution {
    public int solution(int N, int number) {
        Set<Integer>[] set = new Set[9];
        for (int i = 1; i <= 8; i++) {
            set[i] = new LinkedHashSet<>();
            String sn = Integer.toString(N);
            String str = "";
            for (int j = 1; j <= i; j++) {
                str += sn;
            }
            set[i].add(Integer.parseInt(str));
        }
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= i - 1; j++) {
                Iterator<Integer> it = set[j].iterator();
                while (it.hasNext()) {
                    int n1 = it.next();
                    Iterator<Integer> it2 = set[i - j].iterator();
                    while (it2.hasNext()) {
                        int n2 = it2.next();
                        set[i].add(n1 + n2);
                        set[i].add(n1 - n2);
                        set[i].add(n1 * n2);
                        if (n2 != 0) {
                            set[i].add(n1 / n2);
                        }
                    }
                }
            }
            if (set[i].contains(number)) {
                return i;
            }
        }
        return -1;
    }
}