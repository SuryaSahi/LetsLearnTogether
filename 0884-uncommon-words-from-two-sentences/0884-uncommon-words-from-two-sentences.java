class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Set<String> str = new HashSet<>();
        Set<String> dupstr = new HashSet<>();
        
         //String array for traversal
        String st1[] = s1.split(" ");
        String st2[] = s2.split(" ");
        for(String word : st1){
            if(!dupstr.contains(word)){
                if(str.contains(word)){
                    str.remove(word);
                    dupstr.add(word);
                }
                else{
                    str.add(word);
                }
            }
        }
        for(String word : st2){
            if(!dupstr.contains(word)){
                if(str.contains(word)){
                    str.remove(word);
                    dupstr.add(word);
                }
                else{
                    str.add(word);
                }
            }
        }
        
        return str.toArray(new String[0]);
    }
}