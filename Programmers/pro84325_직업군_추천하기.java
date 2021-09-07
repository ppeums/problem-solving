class Solution {
    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        int max = 0;
        int[] score = new int[table.length];
        String[][] arr = new String[table.length][6];

        for (int i = 0; i < table.length; i++) {
            arr[i] = table[i].split(" ");
        }

        for (int i = 0; i < languages.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                for (int k = 1; k < 6; k++) {
                    if (arr[j][k].equals(languages[i])) {
                        score[j] += (preference[i] * (6 - k));
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (max < score[i]) {
                max = score[i];
                answer = arr[i][0];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (max == score[i]) {
                answer = (answer.compareTo(arr[i][0]) > 0) ? arr[i][0] : answer;
            }
        }

        return answer;
    }
}