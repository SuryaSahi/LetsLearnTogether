class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        
        StringBuilder str = new StringBuilder();
        
        int num = 0;
        for(char c : s.toCharArray()){
            if(c >= '0' && c <= '9'){
                num = num * 10 + c - '0'; 
            }
            else if(c == '['){
                numStack.add(num);
                num = 0;
                strStack.push(str);
                str = new StringBuilder();
            }
            else if(c == ']'){
                StringBuilder temp = str;
                str=strStack.pop();
                int cnt = numStack.pop();
                while(cnt-- > 0)
                str.append(temp);
            }
            else {
                str.append(c);
            }
        }
        return str.toString();
    }
}