class Solution {
    public int longestStrChain(String[] words) {
        HashSet<String> wordSet = new HashSet<>();
        HashMap<String , Integer> wordMap = new HashMap<>();
        
        for(String word : words)wordSet.add(word);
        int chainLength = 0;
        for(String word : words){
            chainLength = Math.max(chainLength , helper(wordSet , wordMap , word));
        }
        
        return chainLength;
    }
    
    public int helper(HashSet<String> wordSet ,
    HashMap<String , Integer> wordMap , String word){
        if(!wordSet.contains(word))return 0;
        
        if(wordMap.containsKey(word))return wordMap.get(word);
        
        int score = 1;
        for(int i = 0; i<word.length(); i++){
            String newword = word.substring(0,i) + word.substring(i + 1 , word.length());
            score = Math.max(score , 1 + helper(wordSet , wordMap , newword));
        }
        
        wordMap.put(word , score);
        return score;
    }
}