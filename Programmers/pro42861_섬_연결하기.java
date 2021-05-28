import java.util.Arrays;

class Solution {
    static int[] parent;

    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        Bridge[] arr = new Bridge[costs.length];
        for (int i = 0; i < costs.length; i++) {
            Arrays.sort(costs[i], 0, 2);
            arr[i] = new Bridge(costs[i][0], costs[i][1], costs[i][2]);
        }
        Arrays.sort(arr);
        init(n);
        for (int i = 0; i < arr.length; i++) {
            int x = find(arr[i].start);
            int y = find(arr[i].end);
            if (x != y) {
                union(x, y);
                answer += arr[i].cost;
            }
        }
        return answer;
    }

    static void init(int n) {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    static int find(int x) {
        if (x == parent[x]) {
            return x;
        } else {
            return find(parent[x]);
        }
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        parent[y] = x;
    }

    static class Bridge implements Comparable<Bridge> {
        int start, end, cost;

        public Bridge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Bridge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}