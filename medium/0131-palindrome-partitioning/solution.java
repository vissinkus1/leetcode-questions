class Solution {

    public List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();

        backtrack(s, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(
        String s,
        int start,
        List<String> path,
        List<List<String>> result
    ) {

        // We reached the end of the string
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        // Try every possible substring
        for (int end = start; end < s.length(); end++) {

            // Take substring
            String part = s.substring(start, end + 1);

            // Only continue if it is palindrome
            if (isPalindrome(part)) {

                // Choose
                path.add(part);

                // Explore
                backtrack(s, end + 1, path, result);

                // Undo
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}