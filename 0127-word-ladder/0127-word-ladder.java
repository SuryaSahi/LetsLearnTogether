class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
    return 0; // If not in wordList, return 0.
}

int cnt = 0; 
Set<String> dict = new HashSet<>(wordList);
Queue<String> que = new LinkedList<>(); 

que.add(beginWord); 

while (!que.isEmpty()) {
    cnt++; 
    int size = que.size();
    // Loop through the elements in the queue.
    for (int k = 0; k < size; k++) {
        String word = que.poll(); 
        // If the word is the same as the endWord, return the counter.
        if (word.equals(endWord))
            return cnt;
        for (int i = 0; i < word.length(); i++) {
            // Loop through each character 
            for (char ch = 'a'; ch <= 'z'; ch++) {
                char[] arr = word.toCharArray();
                arr[i] = ch; // Change the character at index i to ch.
                String midWord = new String(arr);
                // If the new word is in the dictionary, add it to the queue and remove it from the dictionary.
                if (dict.contains(midWord)) {
                    que.add(midWord);
                    dict.remove(midWord);
                }
            }
        }
    }
}
    return 0;
    }
}