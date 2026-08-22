class Solution {
    public int[][] construct2DArray(int[] original, int m, int nCols) {
        // Check if reshape is possible
        if (original.length != m * nCols) {
            return new int[0][0];
        }

        int[][] result = new int[m][nCols];
        int index = 0;

        // Fill row by row
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < nCols; j++) {
                result[i][j] = original[index++];
            }
        }

        return result;
    }
}
