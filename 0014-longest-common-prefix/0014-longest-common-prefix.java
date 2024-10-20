class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)return "";
        String check = strs[0];
        StringBuilder ans = new StringBuilder();
        
        for(int i = 0; i<check.length(); i++){
            char c = strs[0].charAt(i);
            for(int j = 1; j<strs.length; j++){
                if(i >= strs[j].length() || c != strs[j].charAt(i))return ans.toString();
            }
            ans.append(c);
        }
        return ans.toString();
    }
}