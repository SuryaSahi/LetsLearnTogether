class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(beginWord , 1));
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i<wordList.size(); i++){
            set.add(wordList.get(i));
        }
        
        while(!q.isEmpty()){
            String wr = q.peek().first;
            int steps = q.peek().second;
            q.remove();
            
            if (wr.equals(endWord) == true) return steps;
            
            for(int i = 0; i<wr.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char charArray[] = wr.toCharArray();
                    charArray[i] = ch;
                    String newword = new String(charArray);
                    
                    if(set.contains(newword)){
                        set.remove(newword);
                        q.add(new Pair(newword , steps + 1));
                    }
                    
                }
            }
        }
        return  0;
    }
}

class Pair{
    String first;
    int second;
    Pair(String first , int second){
        this.first = first;
        this.second = second;
    }
}