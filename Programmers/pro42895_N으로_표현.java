import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int N, int number) {
        Set<Integer>[] set = new Set[9];
        for (int i = 1; i <= 8; i++) {
            set[i] = new HashSet<>();
            int num = 0;
            for (int j = 0; j < i; j++) {
                num = num * 10 + N;
            }
            set[i].add(num);
            for (int j = 1; j < i; j++) {
                for (Integer in : set[j]) {
                    for (Integer in2 : set[i - j]) {
                        set[i].add(in + in2);
                        set[i].add(in - in2);
                        set[i].add(in * in2);
                        if (in2 != 0) {
                            set[i].add(in / in2);
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