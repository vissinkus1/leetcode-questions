class Solution {
    public int arraySign(int[] nums) {
        int sign = 1; // start with positive

        for (int num : nums) {
            if (num == 0) return 0; // product becomes zero
            if (num < 0) sign = -sign; // flip sign
        }

        return sign;
    }
}
