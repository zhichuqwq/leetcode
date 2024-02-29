class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0,farest = 0;
        int jump = 0;
        for(int i = 0;i < n - 1;i++){
            farest = Math.max(farest,nums[i] + i);
            if(end == i){
                jump++;
                end = farest;
            }
        }
        return jump;
    }
}
