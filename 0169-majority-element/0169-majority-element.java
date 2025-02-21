import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        // 해시맵으로 nums의 수 세기
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        // 해시맵 돌면서 가장 큰 숫자 찾기
        int maxNum = 0;
        int answer = -1;
        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxNum) {
                answer = entry.getKey();
            }
        }
        
        return answer;
    }
}