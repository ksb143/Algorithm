import java.util.*;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            map.merge(c, 1, (oldVal, newVal) -> oldVal + newVal);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (map.containsKey(c)) {
                int cnt = map.get(c) - 1;
                if (cnt == 0) {
                    map.remove(c);
                    continue;
                }
                map.put(c, cnt);
            } else {
                return false;
            }
        }
        return true;
    }
}