class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int num1 = Integer.MIN_VALUE;
        int num2 = Integer.MIN_VALUE;
        int n = nums.length;
        int cnt1 = 0 ,cnt2 = 0;
        
        for(int i = 0; i<nums.length; i++){
            if(nums[i] != num2 && cnt1 == 0){
                num1 = nums[i];
                cnt1++;
            }
            else if(nums[i] != num1 && cnt2 == 0)
                {
                num2 = nums[i];
                cnt2++;
            }
            
            else if(nums[i] == num1)cnt1++;
            else if(nums[i] == num2)cnt2++;
            else{
                cnt1--;
                cnt2--;
            }    
        }
            cnt1 = 0;
            cnt2 = 0;
            ArrayList<Integer> ans = new ArrayList<>();
            for(int i = 0; i<n; i++){
                if(nums[i] == num1)cnt1++;
                if(nums[i] == num2)cnt2++;
            }
            
            int lenN = (int)n/3 + 1;
            if(cnt1 >= lenN)ans.add(num1);
            if(cnt2 >= lenN)ans.add(num2);
        return ans;
    }
}

// int cnt1 = 0 , cnt2 = 0;
//         int ele1 = Integer.MIN_VALUE;
//         int ele2 = Integer.MIN_VALUE;

//         for(int i = 0; i<v.length; i++){
//             if(v[i] != ele2 && cnt1 == 0){
//                 cnt1++;
//                 ele1 = v[i];
//             }
//             else if(v[i] != ele1 && cnt2 == 0){
//                 cnt2++;
//                 ele2 = v[i];
//             }
//             else if(v[i] == ele1)cnt1++;
//             else if(v[i] == ele2)cnt2++;
//             else{
//                 cnt1--;
//                 cnt2--;
//             }
//         }
//             List<Integer> ans = new ArrayList<>();
//             //manually checking for which passes the n/3 rule
//             cnt1 = 0 ;
//             cnt2 = 0;
//             for(int i = 0; i<v.length; i++){
//                 if(ele1 == v[i])cnt1++;
//                 if(ele2 == v[i])cnt2++;
//             }

//             int n = v.length;
//             int chck = (int) n/3 + 1;

//             if(cnt1 >= chck)ans.add(ele1);
//             if(cnt2 >= chck)ans.add(ele2);
//         return ans;