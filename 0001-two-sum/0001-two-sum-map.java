import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        int N = nums.length;
        int[] ans = new int[2];

        for (int i = 0; i < N; i++) {
            int diff = target - nums[i];
            // 만약 해쉬맵에 해당 숫자 있는지 확인
            if (map.containsKey(diff)) {
                ans[0] = map.get(diff);
                ans[1] = i;
                break;
            }
            // 해쉬맵에 없다면 현재 숫자를 key값, 인덱스를 map에 추가
            map.put(nums[i], i);
        }
        
        return ans;
    }
}