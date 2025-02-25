import java.util.*;

class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            // 숫자 집어넣기
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        
        boolean oddFlag = false;
        int cnt = 0;
        
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int result = entry.getValue() / 2;
            cnt += result * 2;
            if (entry.getValue() % 2 == 1) {
                oddFlag = true;
            }
        }
        if (oddFlag) {
            cnt++;
        }
        return cnt;
    }
}