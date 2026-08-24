# Replace Words

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

In English, we have a concept called root, which can be followed by some other word to form another longer word - let's call this word derivative. For example, when the root "help" is followed by the word "ful", we can form a derivative "helpful".

Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces, replace all the derivatives in the sentence with the root forming it. If a derivative can be replaced by more than one root, replace it with the root that has the shortest length.

Return the sentence after the replacement.

 
Example 1:

Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"


Example 2:

Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
Output: "a a b c"


 
Constraints:


	1 <= dictionary.length <= 1000
	1 <= dictionary[i].length <= 100
	dictionary[i] consists of only lower-case letters.
	1 <= sentence.length <= 106
	sentence consists of only lower-case letters and spaces.
	The number of words in sentence is in the range [1, 1000]
	The length of each word in sentence is in the range [1, 1000]
	Every two consecutive words in sentence will be separated by exactly one space.
	sentence does not have leading or trailing spaces.

## Solution

**Language:** Java  
**Runtime:** 55 ms (beats 30.57%)  
**Memory:** 141.2 MB (beats 5.09%)  
**Submitted:** 2026-08-24T10:51:14.155Z  

```java
class Solution {

    class Node {
        Node[] child = new Node[26];
        boolean end;
    }

    Node root = new Node();

    // Insert dictionary word
    void insert(String word) {
        Node temp = root;

        for (char ch : word.toCharArray()) {
            int i = ch - 'a';

            if (temp.child[i] == null)
                temp.child[i] = new Node();

            temp = temp.child[i];
        }

        temp.end = true;
    }

    // Find shortest root
    String search(String word) {
        Node temp = root;
        String ans = "";

        for (char ch : word.toCharArray()) {
            int i = ch - 'a';

            if (temp.child[i] == null)
                return word;

            ans += ch;
            temp = temp.child[i];

            if (temp.end)
                return ans;
        }

        return word;
    }

    public String replaceWords(List<String> dictionary, String sentence) {

        // Store all roots in Trie
        for (String s : dictionary)
            insert(s);

        String[] arr = sentence.split(" ");
        String result = "";

        for (String s : arr)
            result += search(s) + " ";

        return result.trim();
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/replace-words/)