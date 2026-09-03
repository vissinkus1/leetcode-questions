class Solution {

    class TrieNode {

        TrieNode[] children = new TrieNode[26];

        String word;
    }

    private TrieNode root = new TrieNode();

    private List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

        // Build Trie
        for (String word : words) {
            insert(word);
        }

        int rows = board.length;
        int cols = board[0].length;

        // Start DFS from every cell
        for (int r = 0; r < rows; r++) {

            for (int c = 0; c < cols; c++) {

                dfs(board, r, c, root);
            }
        }

        return result;
    }

    private void insert(String word) {

        TrieNode node = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            node = node.children[index];
        }

        node.word = word;
    }

    private void dfs(
            char[][] board,
            int row,
            int col,
            TrieNode node) {

        // Boundary check
        if (row < 0 ||
            row >= board.length ||
            col < 0 ||
            col >= board[0].length) {

            return;
        }

        // Already visited
        if (board[row][col] == '#') {
            return;
        }

        char ch = board[row][col];

        int index = ch - 'a';

        // Character is not a Trie prefix
        if (node.children[index] == null) {
            return;
        }

        TrieNode next = node.children[index];

        // Found a complete word
        if (next.word != null) {

            result.add(next.word);

            // Avoid adding duplicate word
            next.word = null;
        }

        // Mark current cell as visited
        board[row][col] = '#';

        // Explore four directions
        dfs(board, row - 1, col, next); // up
        dfs(board, row + 1, col, next); // down
        dfs(board, row, col - 1, next); // left
        dfs(board, row, col + 1, next); // right

        // Backtrack
        board[row][col] = ch;
    }
}