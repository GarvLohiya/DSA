class Solution {
    public int longestOnes(int[] nums, int k) {
        int r=0;
        int l=0;
        int n= nums.length;
        int zc=0;
        int res=0;
        while(r<n){
            if(nums[r]==0){
                zc++;
            }
            while(zc>k){
                if(nums[l]==0){
                    zc--;
                }
                l++;
            }
            res=Math.max((r-l+1), res);
            r++;

        }
        return res;
    }
}