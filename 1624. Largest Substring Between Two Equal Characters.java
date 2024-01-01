class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        //solved O(N^2)
        //using hashmap
        int maxdist = 0;
        HashMap<Character , Integer> charmap = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);

            if(charmap.containsKey(c)){
                int diff = i - charmap.get(c);
                maxdist = Math.max(maxdist , diff);
            }
            else {
                charmap.put(c , i);
            }
        }
        return maxdist - 1;
    }
}
// o(n^2) approach 
class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int maxdis = -1;
        for(int i = 0; i<s.length(); i++){
            for(int j = i + 1; j< s.length(); j++){
                if(s.charAt(i) == s.charAt(j)){
                    maxdis = Math.max(maxdis , j - i - 1);
                }
            }
        }
        return maxdis;
    }
}
