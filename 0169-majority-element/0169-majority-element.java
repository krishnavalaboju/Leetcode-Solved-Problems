class Solution {
    public int majorityElement(int[] nums) {
        int a=nums[0];
        int c=0;
        for(int n:nums){
            if(c==0){
                a=n;
            }
            if(n==a)c++;
            else c--;
        }
        return a;
    }
}