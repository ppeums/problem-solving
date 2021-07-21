class Solution {
    boolean[] visited, check;
    String input;
    int answer;

    public int solution(String numbers) {
        int n = numbers.length();
        input = numbers;
        visited = new boolean[n];
        check = new boolean[10000000];
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            int num = input.charAt(i) - '0';
            dfs(n, num);
            visited[i] = false;
        }
        return answer;
    }

    public void dfs(int n, int num) {
        if (!check[num] && isPrimeNumber(num)) {
            check[num] = true;
            answer++;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int tmp = Integer.parseInt(Integer.toString(num) + input.charAt(i));
                dfs(n, tmp);
                visited[i] = false;
            }
        }
    }

    public boolean isPrimeNumber(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}