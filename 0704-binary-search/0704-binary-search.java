class Solution {
    public int search(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;

        int mid = (right + left) / 2;
        
        if (nums[mid] == target) {
            return mid;
        }

        while (right > left) {
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
            mid = (right + left) / 2;
        }

        return -1;
    }
}