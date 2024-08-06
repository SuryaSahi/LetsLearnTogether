class Solution {
    public int minimumPushes(String word) {
        int result = 0;
        
        HashMap<Integer , Integer> map = new HashMap<>();
        
        int assignkey = 2;
        for(int i = 0; i<word.length(); i++){
            if(assignkey > 9)assignkey = 2;
            
            map.put(assignkey , map.getOrDefault(assignkey , 0)+1);
            result += map.get(assignkey);
            assignkey++;
        }
        return result;
    }
}