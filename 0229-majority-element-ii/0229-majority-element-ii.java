class Solution {
    public List<Integer> majorityElement(int[] v) {
        int cnt1 = 0 , cnt2 = 0;
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;

        for(int i = 0; i<v.length; i++){
            if(v[i] != ele2 && cnt1 == 0){
                cnt1++;
                ele1 = v[i];
            }
            else if(v[i] != ele1 && cnt2 == 0){
                cnt2++;
                ele2 = v[i];
            }
            else if(v[i] == ele1)cnt1++;
            else if(v[i] == ele2)cnt2++;
            else{
                cnt1--;
                cnt2--;
            }
        }
            List<Integer> ans = new ArrayList<>();
            //manually checking for which passes the n/3 rule
            cnt1 = 0 ;
            cnt2 = 0;
            for(int i = 0; i<v.length; i++){
                if(ele1 == v[i])cnt1++;
                if(ele2 == v[i])cnt2++;
            }

            int n = v.length;
            int chck = (int) n/3 + 1;

            if(cnt1 >= chck)ans.add(ele1);
            if(cnt2 >= chck)ans.add(ele2);
        return ans;
    }
}