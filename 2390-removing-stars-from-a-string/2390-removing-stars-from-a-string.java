class Solution1 {
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

class Solution {
    public String removeStars(String s){
        Stack<Character> st = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(c == '*')st.pop();
            else st.push(c);
        }
        
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()){
            res.append(st.pop());
        }
        
        return res.reverse().toString();
    }
}