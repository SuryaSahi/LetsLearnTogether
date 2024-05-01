class Solution1 {
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


class Solution {
    public String reversePrefix(String word, char ch){
        int j = word.indexOf(ch);
        
        if( j == -1)return word;
        
        char[] chars = word.toCharArray();
        //swapping  the character from char array instead of creating new variable and iterations
        int i = 0;
        while( i < j){
            char temp = chars[i];
             chars[i] = chars[j];
             chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }
}