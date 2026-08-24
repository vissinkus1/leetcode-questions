# Number of Valid Words for Each Puzzle

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

With respect to a given puzzle string, a word is valid if both the following conditions are satisfied:

	word contains the first letter of puzzle.
	For each letter in word, that letter is in puzzle.
	
		For example, if the puzzle is "abcdefg", then valid words are "faced", "cabbage", and "baggage", while
		invalid words are "beefed" (does not include 'a') and "based" (includes 's' which is not in the puzzle).
	
	

Return an array answer, where answer[i] is the number of words in the given word list words that is valid with respect to the puzzle puzzles[i].
 
Example 1:

Input: words = ["aaaa","asas","able","ability","actt","actor","access"], puzzles = ["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]
Output: [1,1,3,2,4,0]
Explanation: 
1 valid word for "aboveyz" : "aaaa" 
1 valid word for "abrodyz" : "aaaa"
3 valid words for "abslute" : "aaaa", "asas", "able"
2 valid words for "absoryz" : "aaaa", "asas"
4 valid words for "actresz" : "aaaa", "asas", "actt", "access"
There are no valid words for "gaswxyz" cause none of the words in the list contains letter 'g'.


Example 2:

Input: words = ["apple","pleas","please"], puzzles = ["aelwxyz","aelpxyz","aelpsxy","saelpxy","xaelpsy"]
Output: [0,1,3,2,0]


 
Constraints:


	1 <= words.length <= 105
	4 <= words[i].length <= 50
	1 <= puzzles.length <= 104
	puzzles[i].length == 7
	words[i] and puzzles[i] consist of lowercase English letters.
	Each puzzles[i] does not contain repeated characters.

## Solution

**Language:** Java  
**Runtime:** 57 ms (beats 72.12%)  
**Memory:** 79.8 MB (beats 31.73%)  
**Submitted:** 2026-08-24T07:22:22.370Z  

```java
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
```

---

[View on LeetCode](https://leetcode.com/problems/number-of-valid-words-for-each-puzzle/)