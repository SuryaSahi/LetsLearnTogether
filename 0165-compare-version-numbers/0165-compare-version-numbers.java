class Solution1 {
    //57/84 testcases passed in brute force technique
    public int compareVersion(String version1, String version2) {
        int val1 = 0 , val2 = 0;
        for(int i = 0; i<version1.length(); i++){
            if(version1.charAt(i) == '0' || version1.charAt(i) == '.')continue;
            val1 += (int)version1.charAt(i);
        }
        for(int i = 0; i<version2.length(); i++){
            if(version2.charAt(i) == '0' || version2.charAt(i) == '.')continue;
            val2 += (int)version2.charAt(i);
        }
        if(val1 > val2)return 1;
        else if(val1 < val2)return -1;
        return 0;
    }
}

class Solution {
    //69/84
    public int compareVersion(String version1, String version2){
        int i = 0 , j = 0;
        while(i < version1.length() || j < version2.length()){
            int num1 = 0 , num2 = 0;
            while(i < version1.length() && version1.charAt(i) != '.'){
                num1 = num1 * 10 + (version1.charAt(i) - '0');
                i++;
            }
            while(j < version2.length() && version2.charAt(j) != '.'){
                num2 = num2 * 10 + (version2.charAt(j) - '0');
                j++;
            }
            
            if(num1 < num2)return -1;
            if(num1 > num2)return 1;
            
            i++;
            j++;
        }
        return 0;
    }
}

