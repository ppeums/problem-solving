import java.util.Arrays;

class Solution {
    int[] parent;

    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];

        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        init(n);

        for (int[] cost : costs) {
            if (find(cost[0]) != find(cost[1])) {
                union(cost[0], cost[1]);
                answer += cost[2];
            }
        }

        return answer;
    }

    public void init(int n) {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return find(parent[x]);
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        parent[y] = x;
    }
}