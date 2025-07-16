import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('R', 0);
        map.put('T', 0);
        map.put('F', 0);
        map.put('C', 0);
        map.put('M', 0);
        map.put('J', 0);
        map.put('A', 0);
        map.put('N', 0);

        for (int i = 0; i < survey.length; i++) {
            String type = survey[i];
            Character c1 = type.charAt(0);  // 첫 번째 비동의
            Character c2 = type.charAt(1);  // 두 번째 동의

            int score = choices[i];

            if (score < 4) {  // 비동의
                if (score == 1) {
                    score = 3;
                } else if (score == 3) {
                    score = 1;
                }
                map.put(c1, map.get(c1) + score);
            } else if (score > 4) {  // 동의
                score -= 4;
                map.put(c2, map.get(c2) + score);
            }

        }
        
        StringBuilder sb = new StringBuilder();

        if (map.get('R') >= map.get('T')) {
            sb.append('R');
        } else if (map.get('R') < map.get('T')) {
            sb.append('T');
        }
        if (map.get('C') >= map.get('F')) {
            sb.append('C');
        } else if (map.get('C') < map.get('F')) {
            sb.append('F');
        }
        if (map.get('J') >= map.get('M')) {
            sb.append('J');
        } else if (map.get('J') < map.get('M')) {
            sb.append('M');
        }
        if (map.get('A') >= map.get('N')) {
            sb.append('A');
        } else if (map.get('A') < map.get('N')) {
            sb.append('N');
        }

        String answer = sb.toString();
        return answer;
    }
}