import java.util.Arrays;

class Solution {
    public int[] solution(int[] weights, String[] head2head) {
        int n = weights.length;
        int[] answer = new int[n];
        Player[] players = new Player[n];

        for (int i = 0; i < head2head.length; i++) {
            int winHeavy = 0;
            int win = 0;
            int total = 0;
            double winRate = 0;
            String str = head2head[i];

            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 'W') {
                    total++;
                    win++;

                    if (weights[i] < weights[j]) {
                        winHeavy++;
                    }
                } else if (str.charAt(j) == 'L') {
                    total++;
                }
            }

            winRate = (total > 0) ? (double) win / total * 100 : 0;
            Player p = new Player(i + 1, weights[i], winHeavy, winRate);
            players[i] = p;
        }

        Arrays.sort(players);

        for (int i = 0; i < n; i++) {
            answer[i] = players[i].id;
        }

        return answer;
    }

    class Player implements Comparable<Player> {
        int id;
        int weight;
        int winHeavy;
        double winRate;

        public Player(int id, int weight, int winHeavy, double winRate) {
            this.id = id;
            this.weight = weight;
            this.winHeavy = winHeavy;
            this.winRate = winRate;
        }

        @Override
        public int compareTo(Player p) {
            if (this.winRate > p.winRate) {
                return -1;
            } else if (this.winRate == p.winRate) {
                if (this.winHeavy > p.winHeavy) {
                    return -1;
                } else if (this.winHeavy == p.winHeavy) {
                    if (this.weight > p.weight) {
                        return -1;
                    } else if (this.weight == p.weight) {
                        if (this.id < p.id) {
                            return -1;
                        }
                    }
                }
            }

            return 1;
        }
    }
}