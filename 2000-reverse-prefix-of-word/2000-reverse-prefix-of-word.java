class Solution {
    public String reversePrefix(String word, char ch) {
        String result = "";
        int j = 0;
        for(int i = 0; i<word.length(); i++){
            if(word.charAt(i) == ch){
                j = i;
                break;
            }
        }
        char[] rev = new char[j+1];
        int k = 0;
        for(int i = j; i>= 0 && k <= j; i--){
            rev[k] = word.charAt(i);
            k++;
        }
        String neword = new String(rev);
        result += neword;
        result += word.substring(j+1);
        return result;
    }
}
