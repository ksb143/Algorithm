class Solution {
    public int[] twoSum(int[] nums, int target) {
        int N = nums.length;
        int[] ans = new int[2];

        // 이중 루프 한 번에 나오는 방법
        loopOut:
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int temp = nums[i] + nums[j];
                if (temp == target) {
                    ans[0] = i;
                    ans[1] = j;
                    break loopOut;
                }
            }
        }

        return ans;
    }
}