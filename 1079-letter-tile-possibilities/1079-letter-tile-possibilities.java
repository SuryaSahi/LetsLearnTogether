class Solution {
    HashSet<String> ans = new HashSet<>();
    public int numTilePossibilities(String tiles) {
        
        boolean[] visited = new boolean[tiles.length()];
        helper("",tiles,visited);
        return ans.size() - 1;
    }
    public void helper(String str , String tiles , boolean[] visited){
        //int n = tiles.length();
        ans.add(str);
        
        for(int i = 0; i<tiles.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                helper(str+tiles.charAt(i) , tiles , visited);
                visited[i] = false;
            }
        }
    }
}



