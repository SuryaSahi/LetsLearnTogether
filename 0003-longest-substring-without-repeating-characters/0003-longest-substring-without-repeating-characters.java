class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> ans = new HashSet<>();
        int i = 0 , j = 0;
        int maxsize = 0 , size = 0;
        while(i < s.length() && j < s.length()){
            if(!ans.contains(s.charAt(j))){
                size++;
                ans.add(s.charAt(j));
                maxsize = Math.max(size , maxsize);
                j++;
            }
            else{
                size--;
                ans.remove(s.charAt(i));
                i++;
            }
        }
        return maxsize;
    }
}