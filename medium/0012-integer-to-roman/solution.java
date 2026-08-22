class Solution {
    public String intToRoman(int num) {
        // Arrays for values and their corresponding Roman symbols
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {
            "M", "CM", "D", "CD", "C", "XC", "L", "XL", 
            "X", "IX", "V", "IV", "I"
        };

        StringBuilder sb = new StringBuilder();

        // Greedy approach: subtract largest possible value each time
        for (int i = 0; i < values.length && num > 0; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }
}
