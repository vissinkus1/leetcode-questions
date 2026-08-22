class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][];
        
        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= current[1]) {
                // Overlap → merge
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                // No overlap → add current and move on
                merged.add(current);
                current = intervals[i];
            }
        }
        merged.add(current); // add the last interval
        
        return merged.toArray(new int[merged.size()][]);
    }
}
