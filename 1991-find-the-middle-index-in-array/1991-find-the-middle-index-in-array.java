class Solution {
    public int findMiddleIndex(int[] nums) {
        int s=0;
        for(int i:nums)s+=i;
        int l=0;
        for(int i=0;i<nums.length;i++){
            if(l==s-l-nums[i]){
                return i;
            }
            l+=nums[i];
        }
        return -1;
    }
}