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