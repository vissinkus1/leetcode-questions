class Solution {
    public int maxProduct(int[] nums) {
        // Initialize with the first element
        int currentMax = nums[0];
        int currentMin = nums[0];
        int maxProduct = nums[0];

        // Iterate through the array starting from index 1
        for (int i = 1; i < nums.length; i++) {
            int temp = currentMax;

            // Update currentMax and currentMin
            currentMax = Math.max(nums[i], Math.max(nums[i] * currentMax, nums[i] * currentMin));
            currentMin = Math.min(nums[i], Math.min(nums[i] * temp, nums[i] * currentMin));

            // Update global maxProduct
            maxProduct = Math.max(maxProduct, currentMax);
        }

        return maxProduct;
    }
}
