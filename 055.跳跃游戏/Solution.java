class Solution {
    public boolean canJump(int[] nums) {
        int farest = 0,end = 0;
        int n = nums.length;
        for(int i = 0;i < n;i++){
            farest = Math.max(farest,nums[i] + i);
            if(end == i){
                end = farest;
            }
        }
        if(end >= n - 1){
            return true;
        }
        return false;
    }
}
