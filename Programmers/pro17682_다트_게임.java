class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] score = new int[3];
        String[] bonus = new String[3];
        String str = dartResult.replaceAll("[^0-9]", " ").replaceAll("  ", " ");
        String[] tmp = str.split(" ");
        for (int i = 0; i < 3; i++) {
            score[i] = Integer.parseInt(tmp[i]);
        }
        str = dartResult.replaceAll("[0-9]", " ").replaceAll("  ", " ").trim();
        bonus = str.split(" ");
        for (int i = 0; i < 3; i++) {
            if (bonus[i].contains("D"))
                score[i] = (int) Math.pow(score[i], 2);
            else if (bonus[i].contains("T"))
                score[i] = (int) Math.pow(score[i], 3);
            if (bonus[i].contains("*")) {
                score[i] *= 2;
                if (i - 1 >= 0 && i - 1 <= 2)
                    score[i - 1] *= 2;
            } else if (bonus[i].contains("#"))
                score[i] *= -1;
        }
        for (int i = 0; i < 3; i++) {
            answer += score[i];
        }
        return answer;
    }
}