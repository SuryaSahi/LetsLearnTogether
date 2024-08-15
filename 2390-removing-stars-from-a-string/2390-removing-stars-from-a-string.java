class Solution {
    public String removeStars(String s) {
        List<Character> lst = new ArrayList<>();
        String res = "";
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) != '*')lst.add(s.charAt(i));
            else lst.remove(lst.size() - 1);
        }
        
        for(int i = 0; i<lst.size(); i++){
            res += lst.get(i);
        }
        return res;
    }
}