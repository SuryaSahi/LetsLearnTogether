class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> res = new ArrayList<>();
        helper(0,s,res,ans);
        return ans;
    }
    public void helper(int index , String s ,List<String> res, List<List<String>> ans){
        if(index == s.length()){
            ans.add(new ArrayList<>(res));
            return;
        }
        
        for(int i = index; i<s.length(); i++){
            if(ispalin(s,index , i)){
                res.add(s.substring(index , i + 1));
                helper(i + 1 , s , res , ans);
                res.remove(res.size() - 1);
            }
        }
    }
    public boolean ispalin(String s , int start , int last){
        while(start <= last){
            if(s.charAt(start++)  != s.charAt(last--))return false;
        }
        return true;
    }
}