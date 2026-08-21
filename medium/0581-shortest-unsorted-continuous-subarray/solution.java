class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;

        // Find first element out of order from left
        while (left < n - 1 && nums[left] <= nums[left + 1]) {
            left++;
        }

        // Already sorted
        if (left == n - 1) return 0;

        // Find first element out of order from right
        while (right > 0 && nums[right] >= nums[right - 1]) {
            right--;
        }

        // Find min and max in the unsorted subarray
        int subarrayMin = Integer.MAX_VALUE;
        int subarrayMax = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            subarrayMin = Math.min(subarrayMin, nums[i]);
            subarrayMax = Math.max(subarrayMax, nums[i]);
        }

        // Expand left boundary
        while (left > 0 && nums[left - 1] > subarrayMin) {
            left--;
        }

        // Expand right boundary
        while (right < n - 1 && nums[right + 1] < subarrayMax) {
            right++;
        }

        return right - left + 1;
    }
}
