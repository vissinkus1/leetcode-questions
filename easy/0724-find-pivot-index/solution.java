class Solution {
    public int pivotIndex(int[] nums) {
        //int n=nums.size();
        int sum=0;
        for(int num:nums){
            sum +=num;
        }
        int cs=0;
        for(int i=0;i<nums.length;i++){
            int ls=cs;
            int rs=sum-cs-nums[i];
            if(ls==rs)
            return i;
            cs +=nums[i];
        }
        return -1;
    }
}