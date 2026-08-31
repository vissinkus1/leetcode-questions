class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0; // index for next valid element
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i]; // overwrite with valid element
                k++;
            }
        }
        return k;
    }
}
