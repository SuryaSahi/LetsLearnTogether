class Solution1 {
    public void FloydWarshal(int [][]adjMatrix , char[] original, char[] changed, int[] cost){
        //edges weights
        for(int i = 0; i<original.length; i++){
            int s = original[i] - 'a';
            int t = changed[i] - 'a';
            
            adjMatrix[s][t] = Math.min(adjMatrix[s][t] , cost[i]);
        }
        
        //floyd-Warshal Algorithm
        for(int k = 0; k<26; k++){
            for(int i = 0; i<26; i++){
                for(int j = 0; j<26; j++){
                    adjMatrix[i][j] = Math.min(adjMatrix[i][j] , adjMatrix[i][k] + adjMatrix[j][k]); 
                }
            }
        }
    }
    
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost)  {
        int [][]adjMatrix = new int[26][26];
        for(int i = 0; i<26; i++){
            for(int j = 0; j<26; j++){
                adjMatrix[i][j] = Integer.MAX_VALUE;
            }
        }
        
        FloydWarshal(adjMatrix , original , changed , cost);
        
        long ans = 0;
        for(int i = 0; i<source.length(); i++){
            if(source.charAt(i) == target.charAt(i))continue;
            
            if(adjMatrix[source.charAt(i) - 'a'][target.charAt(i) - 'a'] == Integer.MAX_VALUE) return -1;
            
            ans += adjMatrix[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
        }
        
        return ans;
    }
}
class Solution {
    public void FloydWarshal(int [][]adjMatrix , char[] original, char[] changed, int[] cost){
        //edges weights
        for(int i = 0; i < original.length; i++){
            int s = original[i] - 'a';
            int t = changed[i] - 'a';
            adjMatrix[s][t] = Math.min(adjMatrix[s][t] , cost[i]);
        }
        
        //floyd-Warshall Algorithm
        for(int k = 0; k < 26; k++){
            for(int i = 0; i < 26; i++){
                for(int j = 0; j < 26; j++){
                    if(adjMatrix[i][k] != Integer.MAX_VALUE && adjMatrix[k][j] != Integer.MAX_VALUE) {
                        adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j]);
                    }
                }
            }
        }
    }
    
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int [][]adjMatrix = new int[26][26];
        
        // Initialize the adjacency matrix
        for(int i = 0; i < 26; i++){
            for(int j = 0; j < 26; j++){
                if(i == j){
                    adjMatrix[i][j] = 0;
                } else {
                    adjMatrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        FloydWarshal(adjMatrix , original , changed , cost);
        
        long ans = 0;
        for(int i = 0; i < source.length(); i++){
            if(source.charAt(i) == target.charAt(i)) continue;
            
            int from = source.charAt(i) - 'a';
            int to = target.charAt(i) - 'a';
            
            if(adjMatrix[from][to] == Integer.MAX_VALUE) return -1;
            
            ans += adjMatrix[from][to];
        }
        
        return ans;
    }
}
