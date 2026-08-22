class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        int tank = 0, start = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];

            // If tank goes negative, reset start to next station
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        // If total gas is less than total cost, impossible to complete circuit
        return totalGas < totalCost ? -1 : start;
    }
}
