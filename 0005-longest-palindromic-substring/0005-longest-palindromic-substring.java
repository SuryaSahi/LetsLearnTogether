class Solution1 {
    //O(n^2) solution where we assume a character to be center and then on we check its adjacent
    public String longestPalindrome(String s) {
        String res = "";
        int reslen = 0;
        
        for(int i = 0; i<s.length(); i++){
            int l = i , r = i;
            //odd length string check
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if((r - l + 1) > reslen){
                    res = s.substring(l,r+1);
                    reslen = r - l + 1;
                }
                l--;
                r++;
            }
            
            l = i ;
            r = i + 1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if((r - l + 1) > reslen){
                    res = s.substring(l,r+1);
                    reslen = r - l + 1;
                }
                l--;
                r++;
            }
        }
        return res;
    }
}

class Solution{
    //O(n^2) approach with recursion and memoization
    public String longestPalindrome(String s){
        int maxlen = 0;
        String res = "";
        int n = s.length();
        
        int[][] memotab = new int[n + 1][n + 1];
        for (int[] row : memotab) Arrays.fill(row, -1);
        for(int i = 0; i<n; i++){
            for(int j = i; j<n; j++){
                if(palindromeChecker(i,j,s,memotab) == 1){
                    if((j - i + 1) > maxlen){
                        maxlen = j - i  + 1;
                        res = s.substring(i,j + 1);
                    }
                }
            }
        }
        return res;
    }
    public int palindromeChecker(int i , int j , String str , int[][] memotab){
        if( i >= j)return 1;
        
        if(memotab[i][j] != -1)return memotab[i][j];
        
        if(str.charAt(i) == str.charAt(j))return memotab[i][j] = palindromeChecker(i+1,j-1,str,memotab);
        
        return memotab[i][j] = 0;
    }
}