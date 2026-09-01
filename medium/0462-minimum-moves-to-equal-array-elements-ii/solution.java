import java.util.Arrays;

class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int median = nums[n / 2];  // middle element after sorting
        int moves = 0;
        
        for (int num : nums) {
            moves += Math.abs(num - median);
        }
        
        return moves;
    }
}
