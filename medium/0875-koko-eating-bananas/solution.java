class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = 0;

        // Find maximum pile
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        // Binary search
        while (left <= right) {

            int mid = left + (right - left) / 2;

            long hours = 0;

            // Calculate total hours
            for (int pile : piles) {
                hours += (pile + mid - 1) / mid;
            }

            // Speed works
            if (hours <= h) {
                right = mid - 1;
            }
            // Speed is too slow
            else {
                left = mid + 1;
            }
        }

        return left;
    }
}