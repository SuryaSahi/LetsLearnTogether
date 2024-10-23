class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List> map =  new HashMap<>();
        for(String s:strs)
        {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            map.computeIfAbsent(key, k ->new ArrayList()).add(s); 
            //if key is not present then create new ArrayList and add string
        }
        return new ArrayList(map.values());
    }
}