class Solution {

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {

        HashMap<Integer, Integer> frequency = new HashMap<>();

        // Step 1: Build frequency map
        for (String word : words) {
            int mask = createMask(word);

            if (Integer.bitCount(mask) <= 7) {
                frequency.put(mask,
                    frequency.getOrDefault(mask, 0) + 1);
            }
        }

        List<Integer> result = new ArrayList<>();

        // Step 2: Solve each puzzle
        for (String puzzle : puzzles) {

            int puzzleMask = createMask(puzzle);
            int firstLetter = 1 << (puzzle.charAt(0) - 'a');
            int remaining = puzzleMask ^ firstLetter;

            int answer = 0;
            int subset = remaining;

            while (true) {

                int mask = subset | firstLetter;

                answer += frequency.getOrDefault(mask, 0);

                if (subset == 0) break;

                subset = (subset - 1) & remaining;
            }

            result.add(answer);
        }

        return result;
    }

    private int createMask(String str) {

        int mask = 0;

        for (char ch : str.toCharArray()) {
            mask |= 1 << (ch - 'a');
        }

        return mask;
    }
}