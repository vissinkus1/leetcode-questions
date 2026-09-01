class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);  // clear the lowest set bit
        }
        return count;
    }
}
