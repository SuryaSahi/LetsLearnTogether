class Solution1 {
    class TrieNode {
        int idx;
        Map<Character, TrieNode> children = new HashMap<>();
    }

    private TrieNode root = new TrieNode();

    private void trieInsert(String word, int index) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            curr.children.putIfAbsent(ch, new TrieNode());
            curr = curr.children.get(ch);
            curr.idx = index;
        }
    }

    private int trieSearch(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            if (!curr.children.containsKey(ch)) {
                return -1;
            }
            curr = curr.children.get(ch);
        }
        return curr.idx;
    }

    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            trieInsert(words[i], i + 1);
        }
        return trieSearch(searchWord);
    }
}

class Solution{
    public int isPrefixOfWord(String sentence, String searchWord){
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
        if (words[i].startsWith(searchWord)) {
            return i + 1;
            }
        }
    return -1;
    }
}