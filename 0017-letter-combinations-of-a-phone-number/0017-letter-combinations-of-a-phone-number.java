class Solution {
    public List<String> letterCombinations(String a){
        
        HashMap<Character , String> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        
        if(a.length() == 0){
            //ans.add("");
            return ans;
        }
        map.put('0', "0");
        map.put('1', "1");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        helper(map,ans,0,"",a);
        return ans;
    }
    public static void helper(HashMap<Character , String> map ,List<String> ans , int index , String temp , String a ){
            if(index == a.length()){
                ans.add(temp);
                return;
            }
            String s = map.get(a.charAt(index));
            for(int i = 0; i<s.length(); i++){
                helper(map,ans,index+1,temp + s.charAt(i),a);
            }
    }
}