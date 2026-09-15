import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0, right = 0, maxLen = 0;
        HashSet<Character> set = new HashSet<>();

        while (right < n) {
            char c = s.charAt(right);

            // If duplicate, shrink window from left
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add current character
            set.add(c);

            // Update max length
            maxLen = Math.max(maxLen, right - left + 1);

            right++;
        }

        return maxLen;
    }
}
