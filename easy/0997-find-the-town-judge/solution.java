class Solution {
    public int findJudge(int n, int[][] trust) {
       int[] trustScore = new int[n + 1];
        
        for (int[] t : trust) {
            trustScore[t[0]]--;  // person trusts someone
            trustScore[t[1]]++;  // person is trusted
        }
        
        for (int i = 1; i <= n; i++) {
            if (trustScore[i] == n - 1) {
                return i; // judge found
            }
        }
        return -1;//no judge
    
    }
}