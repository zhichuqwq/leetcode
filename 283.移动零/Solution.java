class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for(int i : nums){
            if(i != 0){
                nums[slow] = i;
                slow++;
            }
        }
        Arrays.fill(nums,slow,nums.length,0);
    }
}
