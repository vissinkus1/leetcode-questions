class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[2];
    }

    public int findMaximumXOR(int[] nums) {

        TrieNode root = new TrieNode();

        // Insert all numbers
        for (int num : nums) {
            insert(root, num);
        }

        int maxXor = 0;

        // Find best XOR for every number
        for (int num : nums) {
            maxXor = Math.max(maxXor, getMaxXor(root, num));
        }

        return maxXor;
    }

    private void insert(TrieNode root, int num) {

        TrieNode node = root;

        // 30 -> 0 because nums[i] <= 2^31 - 1
        for (int i = 30; i >= 0; i--) {

            int bit = (num >> i) & 1;

            if (node.child[bit] == null) {
                node.child[bit] = new TrieNode();
            }

            node = node.child[bit];
        }
    }

    private int getMaxXor(TrieNode root, int num) {

        TrieNode node = root;
        int result = 0;

        for (int i = 30; i >= 0; i--) {

            int bit = (num >> i) & 1;

            int opposite = bit ^ 1;

            // Prefer opposite bit
            if (node.child[opposite] != null) {

                result |= (1 << i);
                node = node.child[opposite];

            } else {

                node = node.child[bit];
            }
        }

        return result;
    }
}