import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            // 만약 숫자가 이미 있다면 최소 2번 나온 것
            if (map.containsKey(n)) {
                return true;
            } 
            map.put(n, 1);
        }

        // 끝까지 돌았지만 true가 나오지 않았다면 다 다른 숫자
        return false;
    }
}