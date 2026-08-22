class Solution {
    public double averageWaitingTime(int[][] customers) {

        long currentTime = 0;
        long totalWaitingTime = 0;

        for (int[] customer : customers) {

            int arrival = customer[0];
            int cookingTime = customer[1];

            currentTime = Math.max(currentTime, arrival) + cookingTime;

            totalWaitingTime += currentTime - arrival;
        }

        return (double) totalWaitingTime / customers.length;
    }
}