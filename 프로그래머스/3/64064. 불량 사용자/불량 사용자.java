import java.util.*;

class Solution {
        public static boolean isSame(String winner, String cheater) {
        // 길이가 똑같지 않으므로 false return
        if (winner.length() != cheater.length()) {
            return false;
        }
        // 글자를 하나씩 살펴보면서 똑같은지 확인
        for (int i = 0; i < winner.length(); i++) {
            // 같지 않다면
            if(winner.charAt(i) != cheater.charAt(i)) {
                // cheater 글자가 *면 넘어가기
                if (cheater.charAt(i) == '*') {
                    continue;
                }
                return false;
            }
        }
        return true;
    }
    
    public static void comb(ArrayList<ArrayList<Integer>> sameCases, int currIdx, List<Integer> currComb, HashSet<HashSet<Integer>> uniqueComb) {
        if (currIdx == sameCases.size()) {
            HashSet<Integer> currSet = new HashSet<>(currComb);
            if (currSet.size() == sameCases.size()) {
                uniqueComb.add(new HashSet<>(currSet));
            }
            return;
        }

        ArrayList<Integer> currList = sameCases.get(currIdx);
        for (Integer num : currList) {
            currComb.add(num);
            comb(sameCases, currIdx + 1, currComb, uniqueComb);
            currComb.remove(currComb.size() - 1);
        }
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        ArrayList<ArrayList<Integer>> sameCases = new ArrayList<>();
        for (int i = 0; i < banned_id.length; i++) {
            ArrayList<Integer> innerArr = new ArrayList<>();
            for (int j = 0; j < user_id.length; j++) {
                // 둘이 똑같은 거면 j를 넣기
                if (isSame(user_id[j], banned_id[i])) {
                    innerArr.add(j);
                }
            }
            sameCases.add(innerArr);
        }

        HashSet<HashSet<Integer>> uniqueComb = new HashSet<>();
        comb(sameCases, 0, new ArrayList<Integer>(), uniqueComb);


        int answer = uniqueComb.size();
        return answer;
    }
}