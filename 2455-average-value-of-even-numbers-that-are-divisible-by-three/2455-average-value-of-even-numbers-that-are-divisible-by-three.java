class Solution {
    public int averageValue(int[] nums) {
    int a=0,c=0;
    for(int i=0;i<nums.length;i++){
        if(nums[i]%6==0){a+=nums[i]; c++;}
    }
    if(a==0)return 0;
   else return a/c;    
    }
}