class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        //creating a max heap to store the character in increasing order
        PriorityQueue<Character> pq = new PriorityQueue<>((a , b) -> b - a);
        for(char c : s.toCharArray()){
            pq.add(c);
        }
        
        StringBuilder str = new StringBuilder();
        Stack<Character> st = new Stack<>();
        
        int count = 0;
        char prev = pq.peek();
        while(!pq.isEmpty()){
            char curr = pq.poll();
            if(curr == prev){
                if(count < repeatLimit){
                    str.append(curr);
                }
                else {
                    st.push(curr);
                }
                count++;
            }
            else{
                if(st.isEmpty()){
                    count = 0;
                    count++;
                    str.append(curr);
                    prev = curr;
                }
                else{
                    str.append(curr);
                    count = 0;
                    while(!st.isEmpty() && count < repeatLimit){
                        str.append(st.pop());
                        count++;
                    }
                }
            }
        }
        
        return str.toString();
    }
}