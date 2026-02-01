package programmers.book.P56;

import java.util.*;

// programmers P56. 스킬트리
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        LinkedList<Character> skillOrder = new LinkedList<>();
        Set<Character> skillSet = new HashSet<>();

        for (char c : skill.toCharArray()) {
            skillOrder.add(c);
            skillSet.add(c);
        }

        for (String s : skill_trees) {
            if (checkSkill(s, skillOrder, skillSet)) {
                answer += 1;
            }
        }

        return answer;
    }

    public boolean checkSkill(String skill_tree, LinkedList<Character> skillOrder, Set<Character> skillSet) {
        LinkedList<Character> order = new LinkedList<>(skillOrder);

        for (char c : skill_tree.toCharArray()) {
            if (skillSet.contains(c)) {
                if (!order.poll().equals(c)) return false;
            }
        }
        return true;
    }
}