class Solution {
    public int smallestRangeII(int[] nums, int k) {
        int n = nums.length;
        java.util.Arrays.sort(nums);
        
        int ans = nums[n - 1] - nums[0];
        
        for (int i = 1; i < n; i++) {
            int minVal = Math.min(nums[0] + k, nums[i] - k);
            int maxVal = Math.max(nums[i - 1] + k, nums[n - 1] - k);
            ans = Math.min(ans, maxVal - minVal);
        }
        
        return ans;
    }
}
