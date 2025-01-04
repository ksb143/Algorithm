import java.util.*;

// s, t 두개의 문자열 제공
// t가 s의 애나그램인지 여부에 따라 true/false 배출

class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();

        for (char x : s.toCharArray()) {
            if (mapS.containsKey(x)) {
                mapS.put(x, mapS.get(x) + 1);
            } else {
                mapS.put(x, 1);
            }
        }

        for (char y : t.toCharArray()) {
            if (mapT.containsKey(y)) {
                mapT.put(y, mapT.get(y) + 1);
            } else {
                mapT.put(y, 1);
            }
        }
        
        boolean flag = true;
        
        for (Map.Entry<Character, Integer> entry : mapS.entrySet()) {
            if (entry.getValue() != mapT.get(entry.getKey())) {
                flag = false;
            }
        }

        for (Map.Entry<Character, Integer> entry : mapT.entrySet()) {
            if (entry.getValue() != mapS.get(entry.getKey())) {
                flag = false;
            }
        }

        return flag;
    }
}