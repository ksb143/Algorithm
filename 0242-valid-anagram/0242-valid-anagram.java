import java.util.*;

// s, t 두개의 문자열 제공
// t가 s의 애나그램인지 여부에 따라 true/false 배출

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> countMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            countMap.put(sChar, countMap.getOrDefault(sChar, 0) + 1);
            countMap.put(tChar, countMap.getOrDefault(tChar, 0) - 1);
        }

        for (int cnt : countMap.values()) {
            if (cnt != 0) {
                return false;
            }
        }

        return true;
    }
}