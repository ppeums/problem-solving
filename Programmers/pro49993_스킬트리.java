class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (int i = 0; i < skill_trees.length; i++) {
            int before = -1, idx = -1;
            boolean isPossible = true;
            for (int j = 0; j < skill_trees[i].length(); j++) {
                String str = Character.toString(skill_trees[i].charAt(j));
                if (skill.contains(str)) {
                    idx = skill.indexOf(str);
                    if (before + 1 < idx) {
                        isPossible = false;
                        break;
                    }
                    before = Math.max(before, idx);
                }
            }
            if (isPossible) answer++;
        }
        return answer;
    }
}