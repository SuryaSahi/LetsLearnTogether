class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {
            if(a.solider == b.solider)return a.row - b.row;
            return a.solider - b.solider;
        });
        
        int n = mat.length;
        int m = mat[0].length;
        
        for(int i = 0; i<n; i++){
            int soldier = 0;
            for(int j = 0; j<m; j++){
                if(mat[i][j] == 1)soldier++;
            }
            
            pq.add(new Pair(soldier , i));
        }
        
        int[] ans = new int[k];
        int i = 0;
        while(k-- > 0){
            Pair temp = pq.poll();
            ans[i] = temp.row;
            i++;
        }
        
        return ans;
    }
}

class Pair{
    int solider;
    int row;
    
    Pair(int solider , int row){
        this.solider = solider;
        this.row = row;
    }
}