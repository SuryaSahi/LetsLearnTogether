class Solution {
    public int countSeniors(String[] details) {
        int cnt = 0;
        int n = 15;
        
        for(String str : details){
            String temp = "";
            temp += str.charAt(11);
            temp += str.charAt(12);   
            //System.out.println(temp);
            if(Integer.valueOf(temp) > 60)cnt++;
        }
        return cnt;
    }
}