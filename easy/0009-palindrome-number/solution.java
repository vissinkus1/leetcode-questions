class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindromes
        if (x < 0) {
            return false;
        }

        int duplicatex = x;
        int revnum = 0;
        while (x != 0) {
            int lastdigit = x % 10;
            revnum = (revnum * 10) + lastdigit;
            x = x / 10;
        }
        return revnum == duplicatex;
    }
}
